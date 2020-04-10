package com.xxf.demo.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

//阻塞队列
public class BlockingQueueApiDemo {
    public static void main(String[] args) {
        BlockingQueueApiDemo blockingQueueApiDemo = new BlockingQueueApiDemo();
//        blockingQueueDemo.test1();

//        blockingQueueDemo.test2();
//        blockingQueueDemo.test3();
        blockingQueueApiDemo.test4();

    }

    /**
     * 抛异常 （add, remove)
     */
    public void test1() {
        //队列大小
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(2);
        System.out.println(arrayBlockingQueue.add("a"));
        System.out.println(arrayBlockingQueue.add("b"));
//        System.out.println(arrayBlockingQueue.add("c")); //抛异常
        System.out.println(arrayBlockingQueue.element()); //取出队首元素
        System.out.println("==========================================");
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove()); // 抛异常
    }


    /**
     * 不抛异常, 有返回值
     */
    public void test2() {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(2);
        System.out.println(arrayBlockingQueue.offer("a"));
        System.out.println(arrayBlockingQueue.offer("b"));
        System.out.println(arrayBlockingQueue.offer("c")); //false

        System.out.println(arrayBlockingQueue.peek()); //取出队首元素
        System.out.println("==========================================");

        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll()); //null
    }

    /**
     * 阻塞,等待
     */
    public void test3() {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(2);
        try {
            arrayBlockingQueue.put("a");
            arrayBlockingQueue.put("b");
//            arrayBlockingQueue.put("c"); //队列没有位置了 阻塞

            System.out.println(arrayBlockingQueue.take());
            System.out.println(arrayBlockingQueue.take());
            System.out.println(arrayBlockingQueue.take()); ////队列没有元素 阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    /**
     * 超时等待
     */
    public void test4() {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(2);

        try {
            System.out.println(arrayBlockingQueue.offer("a"));
            System.out.println(arrayBlockingQueue.offer("b"));
            System.out.println(arrayBlockingQueue.offer("c", 2, TimeUnit.SECONDS)); //等待两秒，就退出

            System.out.println(arrayBlockingQueue.peek()); //取出队首元素
            System.out.println("==========================================");

            System.out.println(arrayBlockingQueue.poll());
            System.out.println(arrayBlockingQueue.poll());
            System.out.println(arrayBlockingQueue.poll(2, TimeUnit.SECONDS)); //等待两秒，就退出
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
