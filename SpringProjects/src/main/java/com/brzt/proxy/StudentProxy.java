package com.brzt.proxy;

import com.brzt.impl.PrimaryStudent;
import com.brzt.interf.Student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author puhome
 * @data 2020/7/28
 */
public class StudentProxy implements InvocationHandler {

    private Student student;

    /**
     * 生成动态代理
     * @return
     */
    public Student  getStudent()
    {
        Student student= (Student) Proxy.newProxyInstance(StudentProxy.class.getClassLoader(), PrimaryStudent.class.getInterfaces(),this);
        return  student;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //业务之前的方法
        System.out.println("初始化proxy");

        Object object= method.invoke(student,args);

        //业务之后的方法
        System.out.println("销毁proxy");
        return object;
    }

    public StudentProxy(){}

    public StudentProxy(Student student){
        super();
        this.student=student;
    }

}
