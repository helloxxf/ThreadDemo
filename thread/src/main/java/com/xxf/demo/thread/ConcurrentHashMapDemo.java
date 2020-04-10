package com.xxf.demo.thread;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HashMap 不安全
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        // 默认等价于 new HashMap<>(16, 0.75);  初始化容量，加载因子
        Map<String, String> map = new HashMap<>();


        /**
         * Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
         * Map<String, String> map = new ConcurrentHashMap<>();
         */
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
               map.put(Thread.currentThread().getName(), UUID.randomUUID().toString());
            }, String.valueOf(i)).start();
        }

    }
}
