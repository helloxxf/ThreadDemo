package com.xxf.demo.thread;

import com.xxf.demo.data.MyCacheLock;

public class ReentrantReadWriteLockDemo {

    public static void main(String[] args) {

        MyCacheLock myCacheLock = new MyCacheLock();
        //写入
        for (int i = 0; i < 5; i++) {
            int temp = i;
            new Thread(() -> {
                myCacheLock.set(temp + "", temp + "");
            }, String.valueOf(i)).start();
        }

        //读取
        for (int i = 0; i < 5; i++) {
            int temp = i;
            new Thread(() -> {
                myCacheLock.get(temp + "");
            }, String.valueOf(i)).start();
        }
    }
}
