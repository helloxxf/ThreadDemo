package com.xxf.demo.thread;

import com.xxf.demo.data.Ticket2;

public class LockDemo {
    public static void main(String[] args) {
        Ticket2 ticket1 = new Ticket2();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                ticket1.sale(1);
            }, "A").start();
        }

        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                ticket1.sale(1);
            }, "B").start();
        }

        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                ticket1.sale(1);
            }, "C").start();
        }
    }
}


