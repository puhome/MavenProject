package com.brzt.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Redis 实现分布式锁，基于setnx(set if not exists)，释放锁通过del指令完成
 */
public class RedisLock implements Lock {

    @Override
    public void lock() {
        while (true)
        {
            boolean b=true;//setnx product1900 1,成功返回true，失败返回false
            if(b)
            {
                return;
            }
            else
            {
                System.out.println("等待中");
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        //del product1900
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
