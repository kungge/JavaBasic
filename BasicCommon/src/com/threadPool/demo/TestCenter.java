package com.threadPool.demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 */
public class TestCenter {

    public static void main(String[] args) {
        test2();
    }

    /**
     * 线程池测试
     */
    static void test1(){
        System.out.println("*************test1-start****************");

        ExecutorService pool=rtnExecutorService2();

        Thread t1=new ThreadAssist();
        Thread t2=new ThreadAssist();
        Thread t3=new ThreadAssist();
        Thread t4=new ThreadAssist();
        Thread t5=new ThreadAssist();

        //将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);

        //关闭线程池
        pool.shutdown();

        System.out.println("*************test1-end****************");
    }

    /**
     * 延迟连接池测试
     */
    static void test2(){
        System.out.println("*************test2-start****************");

        //ScheduledExecutorService pool=rtnExecutorService3(2);//延迟连接池
        ScheduledExecutorService pool=rtnExecutorService4();//单任务延迟连接池

        Thread t1=new ThreadAssist();
        Thread t2=new ThreadAssist();
        Thread t3=new ThreadAssist();
        Thread t4=new ThreadAssist();
        Thread t5=new ThreadAssist();

        //将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);

        pool.schedule(t4,10, TimeUnit.MILLISECONDS);
        pool.schedule(t5,10, TimeUnit.MILLISECONDS);

        //关闭线程池
        pool.shutdown();

        System.out.println("*************test2-end****************");
    }

    /**
     * 固定大小的线程池
     */
    static ExecutorService rtnExecutorService1(){
        //ExecutorService pool=Executors.newFixedThreadPool(3);
        ExecutorService pool=Executors.newSingleThreadExecutor();//单任务线程池

        return pool;
    }

    /**
     * 可变尺寸的线程池
     */
    static ExecutorService rtnExecutorService2(){
        ExecutorService pool=Executors.newCachedThreadPool();

        return pool;
    }

    static ScheduledExecutorService rtnExecutorService3(int poolSize){
        ScheduledExecutorService pool=Executors.newScheduledThreadPool(poolSize);

        return pool;
    }

    static ScheduledExecutorService rtnExecutorService4(){
        ScheduledExecutorService pool=Executors.newSingleThreadScheduledExecutor();

        return pool;
    }
}
