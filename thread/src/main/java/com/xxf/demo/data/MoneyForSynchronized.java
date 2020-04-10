package com.xxf.demo.data;

public class MoneyForSynchronized {

    private int m = 0;

    /**
     * 生产钱
     * @throws InterruptedException
     */
    public synchronized void producer() throws InterruptedException {
        //防止虚假唤醒，还有钱不生产
        while (m != 0) {
            this.wait();
        }
        m++;
        System.out.println(Thread.currentThread().getName() + "生产1元钱,当前共有：" + m + "元");
        this.notifyAll();
    }

    /**
     * 花钱
     * @throws InterruptedException
     */
    public synchronized void consumer() throws InterruptedException {
        //防止虚假唤醒，没钱了等待生产
        while (m == 0) {
            this.wait();
        }
        m--;
        System.out.println(Thread.currentThread().getName() + "花了1元钱，还剩：" + m + "元");
        this.notifyAll();
    }
}
