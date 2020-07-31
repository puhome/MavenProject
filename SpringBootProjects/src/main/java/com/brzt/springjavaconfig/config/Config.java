package com.brzt.springjavaconfig.config;


import com.brzt.springjavaconfig.factory.StudentFactory;
import com.brzt.springjavaconfig.impl.Person;
import com.brzt.springjavaconfig.impl.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@Configuration标签，把一个类标记为spring配置对象，替代xml配置方式
 * @author puhome
 * @data 2020/7/30
 */
@Configuration
public class Config {

    @Bean(name = "person",initMethod = "init",destroyMethod = "destroy")
    public Person person(Student studentFactory)
    {
        Person person=new Person();
        person.setStudent(studentFactory);
        return  person;
    }

    @Bean(name = "studentFactory")
    public StudentFactory studentFactory(){
        System.out.println("studentFactory1");
        return new StudentFactory();
    }

    @Bean(name = "studentFactory2")
    public StudentFactory studentFactory2(){
        System.out.println("studentFactory2");
        return new StudentFactory();
    }
}
