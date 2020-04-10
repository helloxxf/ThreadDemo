package com.xxf.demo.data;

public class Ticket1 {
    public int count = 50;

    public synchronized void sale(int n) {
        if (count > 0) {
            count = count - n;
            System.out.println(Thread.currentThread().getName() + ": 卖出 " + n + "张票：剩余" + count);
        }
    }
}
