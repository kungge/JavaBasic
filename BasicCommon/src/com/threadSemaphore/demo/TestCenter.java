package com.threadSemaphore.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程信号量
 */
public class TestCenter {
    public static void main(String[] args) {
        test1();
    }

    static void test1(){

        System.out.println("*************test1-start****************");

        MyPool myPool=new MyPool(20);

        //创建一个线程池
        ExecutorService pool= Executors.newFixedThreadPool(2);

        MyThread t1=new MyThread("Thread1",myPool,3);
        MyThread t2=new MyThread("Thread2",myPool,12);
        MyThread t3=new MyThread("Thread3",myPool,7);

        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);

        pool.shutdown();

        System.out.println("*************test1-end****************");
    }
}
