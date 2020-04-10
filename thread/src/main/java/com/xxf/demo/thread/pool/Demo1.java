package com.xxf.demo.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Executors工具类， 三大方法
public class Demo1 {

    public static void main(String[] args) {
        ExecutorService threadPool =  Executors.newSingleThreadExecutor(); //单线程，线程池
//        ExecutorService threadPool =  Executors.newFixedThreadPool(5);  //固定线程，线程池
//        ExecutorService threadPool = Executors.newCachedThreadPool(); //可伸缩

        //使用线程池创建线程
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " hello!");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //线程用完要关闭
            threadPool.shutdown();
        }
    }
}
