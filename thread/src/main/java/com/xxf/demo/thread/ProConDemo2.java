package com.xxf.demo.thread;

import com.xxf.demo.data.MoneyForLock;

//生产消费： 等待 通知
public class ProConDemo2 {
    public static void main(String[] args) {

        MoneyForLock moneyForLock = new MoneyForLock();

        for (int i = 0; i < 100; i++) {
            //生产
            new Thread(() -> {
                moneyForLock.producer();
            }, "A").start();
        }

        for (int i = 0; i < 100; i++) {
            //消费
            new Thread(() -> {
                moneyForLock.consumer();
            }, "B").start();
        }

    }
}
