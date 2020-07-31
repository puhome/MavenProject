package com.brzt.springjavaconfig;

import com.brzt.springjavaconfig.condition.TeacherCondition;
import com.brzt.springjavaconfig.impl.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author puhome
 * @data 2020/7/31
 */
@Configuration
public class ConditionConfig {

    @Bean
    /**
     *如TeacherCondition中的matchs方法 返回的是false spring不会实例化此bean
     */
    @Conditional(TeacherCondition.class)
    public Teacher teacher()
    {
        return  new Teacher();
    }
}
