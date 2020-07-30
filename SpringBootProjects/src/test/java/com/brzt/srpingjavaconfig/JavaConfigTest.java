package com.brzt.srpingjavaconfig;

import com.brzt.springjavaconfig.impl.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.brzt.springjavaconfig.config.config;

/**
 * @author puhome
 * @data 2020/7/30
 */
public class JavaConfigTest {

    /**
     * SpingJavaConfig
     */
    @Test
    public void  personTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(config.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);
    }
}
