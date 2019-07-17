package com.threadAtomic.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 原子量测试
 */
public class TestCenter {
    public static void main(String[] args) {
        test2();
    }

    /**
     * 使用条件变量
     */
    static void test1() {
        System.out.println("*************test1-start****************");

        ExecutorService pool= Executors.newFixedThreadPool(2);

        Runnable r1=new ThreadAssist("Jack",10000);
        Runnable r2=new ThreadAssist("Jack2",6000);
        Runnable r3=new ThreadAssist("Jack3",500);
        Runnable r4=new ThreadAssist("Jack4",2000);

        //执行各个线程
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);

        //关闭线程
        pool.shutdown();

        System.out.println("*************test1-end****************");
    }

    static void test2(){
        System.out.println("*************test2-start****************");

        ExecutorService pool= Executors.newFixedThreadPool(2);

        Lock lock=new ReentrantLock(false);

        Runnable r1=new ThreadAssist2("Jack",10000,lock);
        Runnable r2=new ThreadAssist2("Jack2",6000,lock);
        Runnable r3=new ThreadAssist2("Jack3",500,lock);
        Runnable r4=new ThreadAssist2("Jack4",2000,lock);

        //执行各个线程
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);

        //关闭线程
        pool.shutdown();


        System.out.println("*************test2-end****************");
    }
}
