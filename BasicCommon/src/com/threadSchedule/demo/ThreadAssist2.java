package com.threadSchedule.demo;

public class ThreadAssist2 implements Runnable {
    public void run() {
        for (int i = 1; i < 4; i++) {
            System.out.println("ThreadAssist2 线程第" + i + "次执行");
            Thread.yield();//让步
        }
    }
}
