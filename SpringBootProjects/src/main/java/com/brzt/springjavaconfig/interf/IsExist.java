package com.brzt.springjavaconfig.interf;

import com.brzt.springjavaconfig.condition.TeacherCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * 自定义注解interface
 * @author puhome
 * @data 2020/7/31
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Conditional(TeacherCondition.class)
public  @interface IsExist {
    Class<?> value();
}

