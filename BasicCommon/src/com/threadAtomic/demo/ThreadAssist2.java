package com.threadAtomic.demo;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;

/**
 * 原子量
 */
public class ThreadAssist2 implements Runnable {
    private String name;
    private int x;
    private Lock lock;

    private static AtomicLong atomicLong=new AtomicLong(10000);

    public ThreadAssist2(String name,int x,Lock lock){
        this.name=name;
        this.x=x;
        this.lock=lock;
    }

    public void run(){
        lock.lock();
        System.out.println(name+"执行了"+x+",当前余额："+atomicLong.addAndGet(x));
        lock.unlock();
    }
}
