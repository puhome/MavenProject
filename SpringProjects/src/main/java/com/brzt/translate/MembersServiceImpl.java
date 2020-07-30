package com.brzt.translate;

import com.brzt.dao.MembersDao;
import com.brzt.entity.Members;
import com.brzt.interf.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * transactionTemplate配置事务
 * @author puhome
 * @data 2020/7/30
 */
@Component
public class MembersServiceImpl implements MembersService {

    @Autowired(required = false)
    @Qualifier("membersImpl")
    MembersDao membersDao;

    /**
     * 事务
     */
    @Autowired(required = false)
    private TransactionTemplate transactionTemplate;

    @Override
    public void getService(int aid, int did, int age) throws Exception {

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {

                try {
                    membersDao.addAge(aid, age);//增加年龄
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //System.out.println(1 / 0);//抛出异常 中断事务,将此放到上面的try里面 则事务不起作用???
                try {
                    membersDao.subAge(did, age);//减少年龄
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
