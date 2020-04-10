package com.xxf.demo.myvolatile;

import java.util.concurrent.TimeUnit;

/**
 * JMM -> Java内存模型
 * main线程已经把num变为1，但是另一个线程不知道还为0，死循环
 */
public class JmmDemo {

    static int num = 0;
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
