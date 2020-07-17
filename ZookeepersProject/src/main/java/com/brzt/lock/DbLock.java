package com.brzt.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 借助数据库实现分布式锁
 */
public class DbLock implements Lock {

    /**
     * 上锁
     */
    @Override
    public void lock() {
        while(true)
        {
            boolean b=tryLock();
            if(b)
            {
                //添加一条锁记录
                return;
            }else
            {
                System.out.println("等待中");
            }

        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    /**
     * 尝试获取锁，根据指定的名称在数据库表中发起一次查询
     * @return
     */
    @Override
    public boolean tryLock() {

        //假如查询记录为null 则return true
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    /**
     * 解锁
     */
    @Override
    public void unlock() {
        //删除锁记录
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
