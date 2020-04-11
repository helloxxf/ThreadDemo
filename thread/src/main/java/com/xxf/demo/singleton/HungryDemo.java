package com.xxf.demo.singleton;

/**
 * 单例模式
 * 饿汉式
 */
public class HungryDemo {

    private HungryDemo() {

    }

    private static HungryDemo INSTANCE = new HungryDemo();

    public static HungryDemo getInstance() {
        return INSTANCE;
    }
}
