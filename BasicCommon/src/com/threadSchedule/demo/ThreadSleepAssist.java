package com.threadSchedule.demo;

public class ThreadSleepAssist extends Thread {
    public void run(){
        for (int i=1;i<4;i++){
            System.out.println("ThreadSleepAssist 线程第"+i+"次执行");
            try{
                System.out.println("ThreadSleepAssist 开始休眠");

                Thread.sleep(2000);

                System.out.println("ThreadSleepAssist 休眠完成");
            }
            catch (InterruptedException ex){
               ex.printStackTrace();
            }
        }
    }
}
