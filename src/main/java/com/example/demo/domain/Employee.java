package com.example.demo.domain;

import javax.persistence.*;

//Student实体类 先开发实体类自动生成数据表
@Entity
@Table(name="T_EMPLOYEE")//映射的表名，表名需要自己手动建立
public class Employee {
    /**
     * 主键字段
     */
    private Integer id;
    private String name;
    private Integer age;
    //通过注释自动生成相应的表格
    //自增的解释
    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(length = 20)//设置字段的长度
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
