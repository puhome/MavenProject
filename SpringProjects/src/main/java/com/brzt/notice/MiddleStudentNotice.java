package com.brzt.notice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author puhome
 * @data 2020/7/28
 */
@Component
@Aspect
public class MiddleStudentNotice {

    /**
     * 通用写法
     */
    @Pointcut("execution(* com.brzt.impl.MiddleStudent.*())")
    public  void  getNotice()
    {

    }

    /**
     * 单独写法
     */
    @Before("execution(* com.brzt.impl.MiddleStudent.*())")
    public void getBefore()
    {
        System.out.println("前置通知");
    }

    //@After("MiddleStudentNotice.getNotice()")
    @After("execution(* com.brzt.impl.MiddleStudent.*())")
    public void getAfter()
    {
        System.out.println("后置通知");
    }

    public void getFinal()
    {
        System.out.println("最终通知");
    }

//    public Object getAround(MethodInvocationProceedingJoinPoint pj)
//    {
//        System.out.println("环绕通知前");
//        Object object= null;
//        try {
//            object = pj.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        System.out.println("环绕通知后");
//        return object;
//    }


    public void  getException()
    {
        System.out.println("异常通知");
    }

}
