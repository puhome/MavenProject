package com.brzt.springjavaconfig.factory;

import com.brzt.springjavaconfig.impl.Student;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author puhome
 * @data 2020/7/31
 */
public class StudentFactory implements FactoryBean<Student> {
    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public Student getObject() throws Exception {
        return new Student();
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }
}
