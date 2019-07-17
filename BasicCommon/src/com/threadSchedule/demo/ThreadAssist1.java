package com.threadSchedule.demo;

public class ThreadAssist1 extends Thread {
    public void run() {
        for (int i = 1; i < 4; i++) {
            System.out.println("ThreadAssist1 线程第" + i + "次执行");
        }
    }
}
