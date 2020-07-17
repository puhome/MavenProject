package com.brzt;

import com.brzt.Stock;
import com.brzt.lock.DbLock;
import com.brzt.lock.RedisLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示线程安全问题
 */
public class StockThread  implements Runnable {

   private static Lock lock=new ReentrantLock();//锁
    private static DbLock dblock=new DbLock();
    private static RedisLock redislock=new RedisLock();
    /**
     * 重写run方法
     */
    @Override
    public void run() {

        //lock.lock();//通过锁解决线程安全问题,但在负载多台服务器环境下，仍无法解决线程安全问题
        //dblock.lock();//借助数据库实现分布式锁
        redislock.lock();//redis实现分布式锁，但如果redis集群中主突然挂掉未同步给从 而此时从又收到加锁请求 则仍然会有问题
                         //通过redisson解决，但网络消耗巨大
        boolean b= Stock.reduceStock();//如果此处异常，将会导致锁无法释放 造成死锁，上锁时可以加过期时间
        //lock.unlock();
        //dblock.unlock();
        redislock.unlock();
        if(b)
        {
            System.out.println(Thread.currentThread().getName()+"库存扣减成功");
        }
        else
        {
            System.out.println(Thread.currentThread().getName()+"库存扣减失败");
        }
    }
}
