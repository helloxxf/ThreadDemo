package com.xxf.demo.thread;


import com.xxf.demo.data.Ticket1;

public class SynchronizedDemo {

    public static void main(String[] args) {
        Ticket1 ticket = new Ticket1();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                ticket.sale(1);
            }, "A").start();
        }

        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                ticket.sale(1);
            }, "B").start();
        }

        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                ticket.sale(1);
            }, "C").start();
        }
    }

}

