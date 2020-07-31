package com.brzt.srpingjavaconfig;

import com.brzt.springjavaconfig.ConditionConfig;
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
@ContextConfiguration(classes = ConditionConfig.class)
public class ConditionConfigTest {

//    @Autowired
//    private Teacher teacher;//如果TeacherCondition.matches返回false 则此会报错，因为sping没有实例化

    @Autowired
    private ApplicationContext applicationContext;

//    @Test
//    public void  test1()
//    {
//        System.out.println(teacher);//如果TeacherCondition.matches返回false 则此会报错，因为sping没有实例化
//    }

    @Test
    public  void  test2() {
        System.out.println(applicationContext.getBeansOfType(Teacher.class).size() );
    }
}
