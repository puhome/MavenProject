package com.brzt.springjavaconfig;

import com.brzt.springjavaconfig.impl.Person;
import com.brzt.springjavaconfig.impl.Teacher;
import com.brzt.springjavaconfig.interf.IsExist;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author puhome
 * @data 2020/7/31
 */
@Configuration
public class ConditionTwoConfig {

    @Bean
    /**
     * 如果存在Teacher的bean 则实例化，否则不实例化
     */
    @IsExist(Teacher.class)
    public Person person(){
        Person person=new Person();
        return  person;
    }

    @Bean
    public Teacher teacher(){
        return new Teacher();
    }
}
