package com.brzt.impl;

import com.brzt.interf.Student;
import org.springframework.stereotype.Component;

/**
 * Spring AOP中的JTarget目标对象
 * @author puhome
 * @data 2020/7/28
 */
//@Component
public class PrimaryStudent implements Student {
    @Override
    public void add() {
        System.out.println("add-配置方式");
    } //Spring AOP中的Joinpoint连接点

    @Override
    public void del() {
        System.out.println("del-配置方式");
    }

    @Override
    public void update() {
        System.out.println("update-配置方式");
    }

    @Override
    public void select() {
        System.out.println("select-配置方式");
    }
}
