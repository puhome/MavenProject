package com.brzt.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //注解的生命周期
@Target(ElementType.TYPE) //注解的范围
public @interface TbStudent {

    String studentName() default ""; //注解需要的参数，默认为空，如果没有默认值 则注解时必须指定名称

    int age() default  0;

    int id() default -1;

    String[] value() default {"1","2"};//注解的数组，一般一个参数 默认参数名为value

}
