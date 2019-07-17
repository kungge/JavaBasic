package com.threadBarrier.demo;

/**
 * 主任务
 */
public class MainTask implements Runnable {
    public void run(){
        System.out.println("主任务执行了");
    }
}
