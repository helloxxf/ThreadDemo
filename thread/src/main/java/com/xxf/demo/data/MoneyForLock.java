package com.xxf.demo.data;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MoneyForLock {

    private int m = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    /**
     * 生产钱
     * @throws InterruptedException
     */
    public void producer() {
        lock.lock();
        try {
            //防止虚假唤醒，还有钱不生产
            while (m != 0) {
                condition.await();
            }
            m++;
            System.out.println(Thread.currentThread().getName() + "生产1元钱,当前共有：" + m + "元");
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 消费
     * @throws InterruptedException
     */
    public void consumer() {
        lock.lock();
        try {
            //防止虚假唤醒，没钱了等待生产
            while (m == 0) {
                condition.await();
            }
            m--;
            System.out.println(Thread.currentThread().getName() + "花了1元钱，还剩：" + m + "元");
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
