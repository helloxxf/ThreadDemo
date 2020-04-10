package com.xxf.demo.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量
 */
public class SemaphoreDemo {
    public static void main(String[] args) {

        //线程数量，举例： 抢车位 ，限流
        Semaphore semaphore = new Semaphore(3);

        //5辆车
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
            //acquire 得到
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到车位");
                    //停2秒
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + "离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //release 释放
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }

    }
}
