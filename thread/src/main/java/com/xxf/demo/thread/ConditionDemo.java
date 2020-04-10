package com.xxf.demo.thread;

import com.xxf.demo.data.MyCondition;

public class ConditionDemo {
    public static void main(String[] args) {
        MyCondition condition = new MyCondition();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                condition.printA();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                condition.printB();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                condition.printC();
            }
        }, "C").start();
    }
}
