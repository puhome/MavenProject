package com.brzt.srpingjavaconfig;

import com.brzt.springjavaconfig.ConfigNew;
import com.brzt.springjavaconfig.impl.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author puhome
 * @data 2020/7/31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfigNew.class)
public class JavaConfigNewTest {

    @Autowired
    private Teacher teacher;

    @Test
    public void teacherTest() {
        System.out.println(teacher.getDriverClass());
    }
}
