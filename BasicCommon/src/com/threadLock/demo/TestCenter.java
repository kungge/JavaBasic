package com.threadLock.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 锁
 */
public class TestCenter {
    public static void main(String[] args) {
        test2();
    }

    static void test1(){
        System.out.println("*************test1-start****************");

        CreditCardAccount account=new CreditCardAccount("9050410450001",10000);

        //创建一个锁对象
        Lock lock=new ReentrantLock();

        //创建一个线程池
        ExecutorService pool= Executors.newCachedThreadPool();

        //创建一些并发访问用户
        CreditCardUser u1=new CreditCardUser("Tom",account,-4000,lock);
        CreditCardUser u2=new CreditCardUser("Tom2",account,6000,lock);
        CreditCardUser u3=new CreditCardUser("Tom3",account,-8000,lock);
        CreditCardUser u4=new CreditCardUser("Tom",account,500,lock);

        //在线程池中执行各个用户的操作
        pool.execute(u1);
        pool.execute(u2);
        pool.execute(u3);
        pool.execute(u4);

        pool.shutdown();

        System.out.println("*************test1-end****************");
    }

    static void test2(){
        System.out.println("*************test2-start****************");

        CreditCardAccount account=new CreditCardAccount("9050411350001",10000);

        //创建一个锁对象
        ReadWriteLock lock=new ReentrantReadWriteLock();

        //创建一个线程池
        ExecutorService pool= Executors.newFixedThreadPool(2);

        //创建一些并发访问用户
        CreditCardUserV2 u1=new CreditCardUserV2("Tom",account,-4000,lock,false);
        CreditCardUserV2 u2=new CreditCardUserV2("Tom2",account,6000,lock,false);
        CreditCardUserV2 u3=new CreditCardUserV2("Tom3",account,-8000,lock,false);
        CreditCardUserV2 u4=new CreditCardUserV2("Tom",account,500,lock,false);
        CreditCardUserV2 u5=new CreditCardUserV2("Tom2",account,0,lock,true);

        //在线程池中执行各个用户的操作
        pool.execute(u1);
        pool.execute(u2);
        pool.execute(u3);
        pool.execute(u4);
        pool.execute(u5);

        pool.shutdown();

        System.out.println("*************test2-end****************");
    }
}
