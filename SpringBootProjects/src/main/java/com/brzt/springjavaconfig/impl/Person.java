package com.brzt.springjavaconfig.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author puhome
 * @data 2020/7/30
 */
public class Person {
    private String name;
    private int age;
    private Student student;
    private  Teacher teacher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //@PostConstruct 此处设置了 则Config 不在写initMethod
    public void init()
    {
        System.out.println("init");
    }

    //@PreDestroy 此处设置了 则Config 不在写destroyMethod
    public void destroy(){
        System.out.println("destroy");
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
