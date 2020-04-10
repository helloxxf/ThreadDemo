package com.xxf.demo.data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 独占锁（写锁）
 * 共享锁 （读锁）
 * 读写锁， 简单实现缓存 - ReadWriteLock
 * 写-写： 不能共存
 * 读-写： 不能共存
 * 读-读： 可以共存
 */

public class MyCacheLock {

    private volatile Map<String, String> map = new HashMap();

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    //写入 ， 保证原子性，写入过程其他线程不可插队
    public void set(String key, String value) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写入：" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入：" + key + "，完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }


    }

    //读取
    public String get(String key) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "读取：" + key);
            String value = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取：" + key + "，完毕");
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
        return "";
    }
}
