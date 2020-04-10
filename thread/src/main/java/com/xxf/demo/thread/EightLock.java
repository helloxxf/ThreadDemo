package com.xxf.demo.thread;

import com.xxf.demo.data.App;

import java.util.concurrent.TimeUnit;

/**
 * 8锁就是关于锁的八个问题
 */
public class EightLock {
    public static void main(String[] args) {
        App app = new App();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            app.weiXin();
        }, "A").start();

        new Thread(() -> {
            app.zhiFuBao();
        }, "B").start();

        new Thread(() -> {
            app.touTiao();
        }, "C").start();
    }
}
