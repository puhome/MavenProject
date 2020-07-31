package com.brzt.srpingjavaconfig;

import com.brzt.springjavaconfig.config.Config;
import com.brzt.springjavaconfig.factory.StudentFactory;
import com.brzt.springjavaconfig.impl.Person;
import com.brzt.springjavaconfig.impl.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class)){
            Person person = applicationContext.getBean("person", Person.class);
            System.out.println(person);

            Student student=applicationContext.getBean("studentFactory",Student.class);
            System.out.println(student);

            StudentFactory studentFactory=applicationContext.getBean("&studentFactory",StudentFactory.class);
            System.out.println(studentFactory);
        }
    }

    @Test
    public void  personTest2() {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class)){
            Person person = applicationContext.getBean("person", Person.class);
            System.out.println(person);
        }
    }
}
