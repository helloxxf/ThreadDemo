package com.xxf.demo.thread;

import com.xxf.demo.data.MoneyForSynchronized;

//生产消费： 等待 通知
public class ProConDemo {
    public static void main(String[] args) {

        MoneyForSynchronized moneyForSynchronized = new MoneyForSynchronized();

        for (int i = 0; i < 100; i++) {
            //生产
            new Thread(() -> {
                try {
                    moneyForSynchronized.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "A").start();
        }

        for (int i = 0; i < 100; i++) {
            //消费
            new Thread(() -> {
                try {
                    moneyForSynchronized.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "B").start();
        }

    }
}
