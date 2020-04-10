package com.xxf.demo.myvolatile;

import java.util.concurrent.TimeUnit;

/**
 * volatile 可见性验证
 */
public class VolatileDemo1 {

    static volatile int num = 0;
    public static void main(String[] args) {

        new Thread(() -> {
            while (num == 0) {
            }
        }, "A").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num = 1;
        System.out.println(num);
    }
}
