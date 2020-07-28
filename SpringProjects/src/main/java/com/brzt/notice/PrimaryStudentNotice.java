package com.brzt.notice;

import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

/**
 * Spring AOP 通知
 * @author puhome
 * @data 2020/7/28
 */
public class PrimaryStudentNotice {
    public void getBefore()
    {
        System.out.println("前置通知");
    }

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
