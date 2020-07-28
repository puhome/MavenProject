package com.brzt.impl;

import com.brzt.interf.Student;
import org.springframework.stereotype.Component;

/**
 * @author puhome
 * @data 2020/7/28
 */
@Component
public class MiddleStudent implements Student {
    @Override
    public void add() {
        System.out.println("add-注解方式");
    }//Spring AOP中的Joinpoint连接点

    @Override
    public void del() {
        System.out.println("del-注解方式");
    }

    @Override
    public void update() {
        System.out.println("update-注解方式");
    }

    @Override
    public void select() {
        System.out.println("select-注解方式");
    }
}
