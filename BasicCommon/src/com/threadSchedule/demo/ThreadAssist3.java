package com.threadSchedule.demo;

public class ThreadAssist3 extends Thread {
    public void run(){
        for (int i=1;i<11;i++){
            System.out.println("ThreadAssist3 线程第"+i+"次执行");

            try{
                Thread.sleep(10);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
