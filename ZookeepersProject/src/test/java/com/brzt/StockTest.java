package com.brzt;

import org.junit.Test;

public class StockTest {

    /**
     * 演示线程安全
     */
    @Test
  public   void  reduceStockTest()
    {
        new Thread(new StockThread(),"线程1").start();
        new Thread(new StockThread(),"线程2").start();
    }

    public  static void main(String args[])
    {
        new Thread(new StockThread(),"线程1").start();
        new Thread(new StockThread(),"线程2").start();
    }
}
