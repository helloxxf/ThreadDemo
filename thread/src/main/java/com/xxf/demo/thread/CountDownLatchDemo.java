package com.xxf.demo.thread;

import java.util.concurrent.CountDownLatch;

//可以理解为减法计数器 CountDownLatch
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //总数
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "号下车");
                countDownLatch.countDown(); //数量减1
            }, String.valueOf(i)).start();
        }
        countDownLatch.await(); //等待计数器归零， 再向下执行
        System.out.println("车上人员已全部离开，关车门");
    }

}
