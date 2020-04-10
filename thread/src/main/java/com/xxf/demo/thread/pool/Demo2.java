package com.xxf.demo.thread.pool;

import java.util.concurrent.*;

/**
 * 线程池七大参数
 * 1、int corePoolSize, 核心线程数
 * 2、int maximumPoolSize, 最大线程数
 * 3、long keepAliveTime, 线程没有被使用最大存活时间
 * 4、TimeUnit unit, 时间单位
 * 5、BlockingQueue<Runnable> workQueue 队列
 * 6、ThreadFactory threadFactory, 线程工厂
 * 7、RejectedExecutionHandler handler 拒绝策略
 * <p>
 * 四种拒绝策略
 * 1、AbortPolicy - 丢弃任务，并抛出拒绝执行 RejectedExecutionException 异常信息。默认的拒绝策略！
 *                  必须处理好抛出的异常，否则会打断当前的执行流程，影响后续的任务执行。
 * 2、CallerRunsPolicy - 当触发拒绝策略，使用调用线程直接运行任务。比如下面代码由main线程处理
 * 3、DiscardOldestPolicy -  当触发拒绝策略，只要线程池没有关闭的话，丢弃阻塞队列中最老的一个任务，并将新任务加入
 * 4、DiscardPolicy - 直接丢弃，不会抛异常
 */

public class Demo2 {

    public static void main(String[] args) {
        //自定义线程池
        ExecutorService threadPool = new ThreadPoolExecutor(2, 5, 60L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(2), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

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
