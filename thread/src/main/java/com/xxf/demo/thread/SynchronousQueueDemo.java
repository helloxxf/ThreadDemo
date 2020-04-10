package com.xxf.demo.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

//同步队列
public class SynchronousQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        //放入
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + " - put: " + "a");
                blockingQueue.put("a");
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + " - put: " + "b");
                blockingQueue.put("b");
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + " - put: " + "c");
                blockingQueue.put("c");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "A").start();

        //取出
        new Thread(() -> {
            try {
                String res1 = blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + " - take: " + res1);
                String res2 = blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + " - take: " + res2);
                String res3 = blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + " - take: " + res3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}
