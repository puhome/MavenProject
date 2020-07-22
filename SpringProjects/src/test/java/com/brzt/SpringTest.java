package com.brzt;

import com.brzt.entity.Person;
import com.brzt.entity.Users;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void  getInfo()
    {
        //创建容器对象
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
        //在容器中找对象
        Users users=(Users) context.getBean("users");
        System.out.println(users.getName());
        System.out.println(users.getId());
        System.out.println(users.getCar().getName());
        System.out.println(users.getCar().getColor());
        Person person= (Person) context.getBean("person");
        System.out.println(person);


    }
}
