package com.brzt;

import com.brzt.impl.MiddleStudent;
import com.brzt.impl.PrimaryStudent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author puhome
 * @data 2020/7/28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/camel-context.xml")
public class SpringAopTest {

    @Autowired(required = false)
    private PrimaryStudent primaryStudent;

    @Autowired(required = false)
    private MiddleStudent middleStudent;

    /**
     * AOP-配置方式
     */
    @Test
    public  void  aopTest()
    {
        primaryStudent.add();
        primaryStudent.del();
    }

    /**
     *AOP-注解方式
     */
    @Test
    public  void aopTest2()
    {
        middleStudent.add();
        middleStudent.del();
    }
}
