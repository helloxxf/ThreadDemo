package com.xxf.demo.data;

import java.util.concurrent.TimeUnit;

public class App {

    /**
     * synchronized 锁同一调用者
     * static 锁 class
     */
    public synchronized void weiXin() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("打开微信");
    }

    public synchronized void zhiFuBao() {
        System.out.println("打开支付宝");
    }

    public synchronized void touTiao() {
        System.out.println("打开今日头题");
    }
}
