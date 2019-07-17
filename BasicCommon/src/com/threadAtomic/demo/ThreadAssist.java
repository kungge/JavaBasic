package com.threadAtomic.demo;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 原子量
 * 程序并发会有问题
 */
public class ThreadAssist implements Runnable {
    private String name;
    private int x;

    private static AtomicLong atomicLong=new AtomicLong(10000);

    public ThreadAssist(String name,int x){
        this.name=name;
        this.x=x;
    }

    public void run(){
        System.out.println(name+"执行了"+x+",当前余额："+atomicLong.addAndGet(x));
    }
}
