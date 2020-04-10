package com.xxf.demo.thread;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

//ArrayList并发不安全问题 java.util.ConcurrentModificationException
public class ListDemo {

    public static void main(String[] args) {



        List<String> list = new ArrayList();

        /**
         * 解决方案：
         * 1、使用Vector  List<String> list = new Vector<>();
         * 2、使用集合工具类 List<String> list = Collections.synchronizedList(new ArrayList<>());
         * 3、使用JUC下的 List<String> list = new CopyOnWriteArrayList<>(); 写时复制技术（底层用了Volatile， 可见性）
         */
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString());
                System.out.println(list);
            }, String.valueOf(i)).start();

        }
    }
}
