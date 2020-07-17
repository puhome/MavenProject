package com.brzt;

/**
 * 库存扣减
 */
public class Stock {
    public static int stockNum=1;

    /**
     * 扣减库存
     * @return
     */
    public static boolean reduceStock() {
        if(stockNum>0)
        {
            try {
                Thread.sleep(1000);//睡眠，出现锁安全问题
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            stockNum--;
            return  true;
        }
        else
        {
            return  false;
        }
    }
}
