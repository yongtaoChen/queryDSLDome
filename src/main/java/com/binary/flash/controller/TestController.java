package com.binary.flash.controller;

import com.binary.flash.demo.QTestDO;
import com.binary.flash.demo.TestDO;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>项目名称：demo</p>
 * <p>类描述：</p>
 * <p>创建人：<a href="mailto:chenyongtao@cdbinary.com"> chenyongtao </a></p>
 * <p>创建时间：2018/9/12 17:37</p>
 */
@Controller
@Api(description = "demo")
public class TestController {

    @PersistenceContext
    private EntityManager entityManager;
    private JPAQuery<TestDO> jpaQuery;
    private QTestDO qTestDO;

    @RequestMapping("/test")
    @ResponseBody
    public  List<TestDO> test() {
        qTestDO = QTestDO.testDO;
        List<BooleanExpression> list = new ArrayList<>();
        list.add(qTestDO.id.eq("123123"));
        list.add(qTestDO.name.like("12313"));
        return test(list);
    }

    void test1() {
        BooleanExpression booleanExpression = qTestDO.name.like("123");
        jpaQuery.where(booleanExpression);
    }

    List<TestDO> test(List<BooleanExpression> list) {
        jpaQuery = new JPAQuery<>(entityManager).select(qTestDO).from(qTestDO);
        BooleanExpression expression = null;
        for (BooleanExpression predicate : list) {
            if (expression == null){
                expression = predicate;
            } else {
                expression = expression.and(predicate);
            }
        }
        return jpaQuery.where(expression).fetch();
    }
}
