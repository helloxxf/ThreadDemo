package com.xxf.demo.myvolatile;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile 不保证原子性 验证
 * 解决方案： 1、synchronized static void add
 *           2、Lock
 *           3、num++不是原子操作, 使用AtomicInteger
 */
public class VolatileDemo2 {

    static volatile int num = 0;
    private volatile static AtomicInteger atomicInteger = new AtomicInteger();


    private static void atomicAdd() {
        atomicInteger.getAndIncrement(); // +1 , CAS
    }

    private static void add() {
        num++;
    }
    public static void main(String[] args) {

//        for (int i = 0; i < 20; i++) {
//            new Thread(() -> {
//                for (int j = 0; j < 1000; j++) {
//                    atomicAdd();
//                }
//            }, String.valueOf(i)).start();
//        }
//
//        while(Thread.activeCount() > 2) { //main gc
//            Thread.yield();
//        }
//        System.out.println("非原子结果" + num);
//

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    atomicAdd();
                }
            }, String.valueOf(i)).start();
        }

        while(Thread.activeCount() > 2) { //main gc
            Thread.yield();
        }
        System.out.println("原子结果：" + atomicInteger);
    }
}
