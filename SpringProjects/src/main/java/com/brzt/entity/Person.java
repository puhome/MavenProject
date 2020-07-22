package com.brzt.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Component注解方式注入,通用
 * 类似于手动注入的bean
 * 如果没有指定名称，则默认类名首字母小写 为bean的名称
 */
//@Component("person")

/**
 *还可以表示前端控制器的对象，表现层
 */
//@Controller("person")

/**
 * 表示业务处理层
 */
//@Service("person")

/**
 * 表示数据访问DAO层
 */
@Repository("person")
//--------------------------------------------------------
/**
 * 同手动注入时的scope属性
 */
@Scope(scopeName="singleton")
public class Person {

    @Value("25")//赋值,不建议用
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Value("zhangsan")//赋值，建议用
    public void setName(String name) {
        this.name = name;
    }
}
