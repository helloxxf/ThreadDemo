package com.xxf.demo.data;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket2 {
    public int count = 50;
    //默认非公平锁
    Lock lock = new ReentrantLock();

    public synchronized void sale(int n) {
        lock.lock();
        try {
            if (count > 0) {
                count = count - n;
                System.out.println(Thread.currentThread().getName() + ": 卖出 " + n + "张票：剩余" + count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
