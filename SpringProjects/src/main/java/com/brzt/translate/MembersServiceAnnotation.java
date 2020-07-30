package com.brzt.translate;

import com.brzt.dao.MembersDao;
import com.brzt.interf.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 通过注解方式配置事务
 * @author puhome
 * @data 2020/7/30
 */
@Component
@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = false)
public class MembersServiceAnnotation implements MembersService {

    @Autowired
    @Qualifier("membersImpl")
    MembersDao membersDao;

    @Override
    public void getService(int aid, int did, int age) throws Exception {
        membersDao.addAge(aid,age);
        //System.out.println(1/0); //记着配<tx:annotation-driven transaction-manager="transactionManager" proxy-target-class="true"/>
        membersDao.subAge(did,age);
    }
}
