package com.brzt.cglib;

import com.brzt.impl.PrimaryStudent;
import com.brzt.interf.Student;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author puhome
 * @data 2020/7/28
 */
public class StudentCglib implements MethodInterceptor {

    /**
     * 创建代理
     * @return
     */
    public PrimaryStudent getPrimaryStudent(){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(PrimaryStudent.class);
        enhancer.setCallback(this);
        PrimaryStudent primaryStudent=(PrimaryStudent) enhancer.create();
        return  primaryStudent;
    }

    /**
     * Spring AOP中的Pointcut切入点
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("初始化cglib");//前置通知
        Object object= methodProxy.invokeSuper(o,objects);
        System.out.println("销毁cglib");//后置通知
        return object;
    }
}
