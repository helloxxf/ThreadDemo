package com.xxf.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        FutureTask futureTask =  new FutureTask<>(thread);
        new Thread(futureTask, "A").start();

        new Thread(futureTask, "B").start(); // 结果会被缓存, 提高效率
        try {
            String res = (String)futureTask.get(); //可能造成阻塞， 可以异步通信解决
            System.out.println(res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

class MyThread implements Callable {

    @Override
    public String call() throws Exception {
        System.out.println("Hello World");
        return "Hello World";
    }
}
