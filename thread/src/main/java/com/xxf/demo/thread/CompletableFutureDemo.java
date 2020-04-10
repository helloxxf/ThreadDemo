package com.xxf.demo.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 异步回调
 * 异步执行
 * 成功回调
 * 失败回调
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //无返回值的异步回调
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("runAsync异步执行");
        });
        System.out.println("11111111111111");
        completableFuture.get();



        //有返回值的异步回调
        CompletableFuture<Integer> completable = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("supplyAsync异步执行");
            return 200;
        });
        System.out.println("11111111111111");

        //返回
        System.out.println(completable.whenComplete((r, s) -> {
            //正常返回结果
            System.out.println("r: " + r);
            //错误信息
            System.out.println("s: " + s);
        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            return 500; //返回错误错误信息
        }).get());

    }
}
