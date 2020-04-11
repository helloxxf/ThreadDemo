package com.xxf.demo.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 单例模式
 * 懒汉式
 *
 */
public class LazyDemo {

    private LazyDemo() {
        System.out.println(Thread.currentThread().getName() + "ok");
    }
    private static LazyDemo INSTANCE;

    private static volatile LazyDemo INSTANCE2;

    //多线程下有问题
    public static LazyDemo getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazyDemo();
        }
        return INSTANCE;
    }

    //双端检锁DCl
    public static LazyDemo getInstance1() {
        if (INSTANCE == null) {
            synchronized (LazyDemo.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazyDemo();
                }
            }
        }
        return INSTANCE;
    }

    //双端检锁DCl, 加上volatile禁止指令重排 1、分配内存空间 2、执行构造方法，初始化对象 3、对象指向空间。 123 指令重排导致 132 其他线程可能会返回一个null
    public static LazyDemo getInstance2() {
        if (INSTANCE == null) {
            synchronized (LazyDemo.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazyDemo();
                }
            }
        }
        return INSTANCE;
    }



    //模拟多线程安全问题
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

//        for (int i = 0; i < 20; i++) {
//            System.out.println(SingletonDemo.getInstance());
//        }

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                LazyDemo.getInstance1();
            }, String.valueOf(i)).start();

        }

//        Constructor<LazyDemo> constructor = LazyDemo.class.getDeclaredConstructor(null);
//        constructor.setAccessible(true);
//        LazyDemo lazyDemo = constructor.newInstance();
//        System.out.println(lazyDemo);
    }
}
