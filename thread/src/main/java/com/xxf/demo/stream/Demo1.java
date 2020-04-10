package com.xxf.demo.stream;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import com.xxf.demo.data.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

//
public class Demo1 {

    public static void main(String[] args) {
        User u1 = new User(1, "zhangsan", 20);
        User u2 = new User(2, "lili", 18);
        User u3 = new User(3, "meinv", 18);
        User u4 = new User(4, "lisi", 16);
        User u5 = new User(5, "wanglao", 16);
        List<User> list = Arrays.asList(u1, u2, u3, u4);
        //获取id是偶数的用户
        list.stream().filter(u -> {
            return u.getId()%2 == 0;
        }).forEach(System.out::println);

        //List转map， id作为key
        Map<Integer, User> map = list.stream().collect(Collectors.toMap(User::getId, user -> user));
        System.out.println(map);


        //并行流
        long start = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(0, 10_0000_0000L).parallel().reduce(0, Long::sum);
        System.out.println("stream结果：" + sum);
        long end = System.currentTimeMillis();
        System.out.println("stream 时间：" + (end -start));

        //传统遍历计算
        long start1 = System.currentTimeMillis();
        long count = 0;
        for (long i = 0; i <= 10_0000_0000L; i++) {

            count = count + i;
        }
        System.out.println("传统结果：" + count);
        long end1 = System.currentTimeMillis();
        System.out.println("传统时间：" + (end1 -start1));

    }
}
