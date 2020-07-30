package com.brzt;

import com.brzt.interf.MembersService;
import com.brzt.translate.MembersServiceAnnotation;
import com.brzt.translate.MembersServiceImpl;
import com.brzt.translate.MerbersServiceImplXml;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author puhome
 * @data 2020/7/30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/camel-context.xml")
public class TranslateTest {

    @Autowired(required = false)
    MembersServiceImpl membersServiceImpl;

    /**
     *注解相当于
     * MerbersServiceImplXml merbersServiceImplXml=new MerbersServiceImplXml();
     * MerbersServiceImplXml类加了注解@Component（交由spring管理对象）
     */
    @Autowired(required = false)
    MerbersServiceImplXml merbersServiceImplXml;

    //@Autowired(required = false)
    //MembersServiceAnnotation membersServiceAnnotation;
    /**
     * 以下两条注解相当于
     * MembersService membersService=new MembersServiceAnnotation();
     * MembersServiceAnnotation类加了注解@Component（交由spring管理对象）
     */
    @Autowired
    @Qualifier("membersServiceAnnotation")
    MembersService membersService;
    /**
     * 通过模板实现事务
     * @throws Exception
     */
    @Test
    public void membersServiceTest() throws Exception {
        membersServiceImpl.getService(1,2,1);
    }

    /**
     * xml配置实现事务
     * @throws Exception
     */
    @Test
    public void merbersServiceImplXml() throws Exception {
        merbersServiceImplXml.getService(1,2,3);
    }

    /**
     * 注解实现事务
     * @throws Exception
     */
    @Test
    public void  membersServiceAnnotation() throws Exception {
        //membersServiceAnnotation.getService(2,1,5);
        membersService.getService(2,1,3);//记着配<tx:annotation-driven transaction-manager="transactionManager" proxy-target-class="true"/>
    }

}
