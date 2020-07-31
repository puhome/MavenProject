package com.brzt.srpingjavaconfig;

import com.brzt.springjavaconfig.ConditionTwoConfig;
import com.brzt.springjavaconfig.impl.Person;
import com.brzt.springjavaconfig.impl.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author puhome
 * @data 2020/7/31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConditionTwoConfig.class)
public class ConditionTwoConfigTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public  void  test() {
        System.out.println(applicationContext.getBeansOfType(Person.class).size() );
    }
}
