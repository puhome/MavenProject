package com.brzt.translate;

import com.brzt.dao.MembersDao;
import com.brzt.interf.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * xml配置事务
 * @author puhome
 * @data 2020/7/30
 */
@Component
public class MerbersServiceImplXml implements MembersService {

    @Autowired(required = false)
    @Qualifier("membersImpl")
    MembersDao membersDao;

    @Override
    public void getService(int aid, int did, int age) throws Exception {
        membersDao.addAge(aid, age);//增加年龄
        System.out.println(1/0);
        membersDao.subAge(did, age);//减少年龄
    }
}
