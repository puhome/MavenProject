package com.brzt;

import com.brzt.cglib.StudentCglib;
import com.brzt.entity.Person;
import com.brzt.entity.Users;
import com.brzt.impl.PrimaryStudent;
import com.brzt.interf.Student;
import com.brzt.proxy.StudentProxy;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void  getInfo()
    {
        //创建容器对象
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
        //在容器中找对象
        Users users=(Users) context.getBean("users");
        System.out.println(users.getName());
        System.out.println(users.getId());
        System.out.println(users.getCar().getName());
        System.out.println(users.getCar().getColor());
        Person person= (Person) context.getBean("person");
        System.out.println(person);
        //配置文件注解
        //EL表达式
        System.out.println(users.getDriver());

        //SqEL表达式
        System.out.println(users.getName());

        //初始化、销毁注解
        context.close();//close后才会调用销毁方法
    }

    /**
     * 动态代理,面向切面时 用此方式
     * 必须实现接口
     */
    @Test
    public void proxyTest(){
        Student student=new PrimaryStudent();
        //获取动态代理工程
        StudentProxy studentProxy=new StudentProxy(student);
        //获取代理对象
        Student student1=studentProxy.getStudent();
        //执行
        student1.select();
    }

    /**
     * Spring的Cglib代理
     * 底层是对类的继承
     * 可以对任何类实现代理（非必须实现接口，用final修饰除外）
     */
    @Test
    public void cglibTest(){

        StudentCglib studentCglib=new StudentCglib();
        PrimaryStudent primaryStudent=studentCglib.getPrimaryStudent();
        primaryStudent.select();
    }

}
