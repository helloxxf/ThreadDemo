package com.xxf.demo.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//可以理解为加法计数器 CyclicBarrier
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        //总数5，车总共5个座位， 坐满就离开
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
            System.out.println("车位已满，驶离。");
        });

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "上车");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
