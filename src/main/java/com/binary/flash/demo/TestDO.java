package com.binary.flash.demo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * <p>项目名称：demo</p>
 * <p>类描述：</p>
 * <p>创建人：<a href="mailto:chenyongtao@cdbinary.com"> chenyongtao </a></p>
 * <p>创建时间：2018/9/12 17:20</p>
 */
@Entity
@Table(name = "test")
public class TestDO {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TestDO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
