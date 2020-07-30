package com.brzt.springjavaconfig.config;


import com.brzt.springjavaconfig.impl.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@Configuration标签，把一个类标记为spring配置对象，替代xml配置方式
 * @author puhome
 * @data 2020/7/30
 */
@Configuration
public class config {

    @Bean
    public Person person()
    {
        return  new Person();
    }
}
