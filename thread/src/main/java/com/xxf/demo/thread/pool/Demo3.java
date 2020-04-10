package com.xxf.demo.thread.pool;

import java.util.concurrent.*;

/**
 * 如何配置线程池最大线程数
 * cpu密集型： 服务器几核，一般设置几个
 * IO密集型： 判断程序中十分消耗IO的线程数 n，设置成大于这个线程数，一般为2n。
 */

public class Demo3 {

    public static void main(String[] args) {
        //自定义线程池
        ExecutorService threadPool = new ThreadPoolExecutor(2, 4, 60L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(2), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

        //获取cpu核数
        System.out.println(Runtime.getRuntime().availableProcessors());

        //使用线程池创建线程
        try {
            for (int i = 0; i < 20; i++) {
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
