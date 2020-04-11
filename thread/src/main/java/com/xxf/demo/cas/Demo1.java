package com.xxf.demo.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * CAS compareAndSet
 * public final boolean compareAndSet(int expect, int update) {
 * return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
 * }
 * <p>
 * 缺点：1、底层自旋耗时。 2、ABA问题
 */
public class Demo1 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        //expect 期望值， update:要更新的值
        atomicInteger.compareAndSet(1, 2);
        System.out.println(atomicInteger.get());
        atomicInteger.compareAndSet(1, 3); //这个时候expect是2了，不是1无法变更为3
        System.out.println(atomicInteger.get());


        //ABA问题
        atomicInteger.compareAndSet(1, 2); //捣乱的
        System.out.println(atomicInteger.get());
        atomicInteger.compareAndSet(2, 1); //捣乱的
        System.out.println(atomicInteger.get());
        // ================真正希望修改的值
        atomicInteger.compareAndSet(1, 5); //捣乱的
        //虽然结果没有错误，但在中间被修改过
        System.out.println("ABA最终期望结果" + atomicInteger.get());

        //ABA问题解决（乐观锁）, initialRef 初始值， initialStamp : 版本号
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference(1, 1);
        int stamp = atomicStampedReference.getStamp(); //获取版本号
        System.out.println("A1版本号:" + stamp);
        System.out.println(atomicStampedReference.compareAndSet(1, 2, 1, stamp + 1));
        System.out.println("A2版本号:" + stamp);
        System.out.println(atomicStampedReference.compareAndSet(2, 1, 2, stamp + 1));
        System.out.println("A3版本号:" + stamp);
        System.out.println(atomicStampedReference.compareAndSet(1, 10, 1, stamp + 1));
        System.out.println("A3版本号:" + stamp);


    }
}
