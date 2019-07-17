package com.threadPool.demo;

public class ThreadAssist extends Thread {
    @Override
    public void run(){
        System.out.println("ThreadAssist 线程 "+Thread.currentThread().getName()+"正在执行...");
    }
}
