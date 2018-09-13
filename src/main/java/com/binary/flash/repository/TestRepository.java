package com.binary.flash.repository;

import com.binary.flash.demo.TestDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * <p>项目名称：demo</p>
 * <p>类描述：</p>
 * <p>创建人：<a href="mailto:chenyongtao@cdbinary.com"> chenyongtao </a></p>
 * <p>创建时间：2018/9/12 17:39</p>
 */
public interface TestRepository extends JpaRepository<TestDO, String>, QuerydslPredicateExecutor<TestDO> {
}
