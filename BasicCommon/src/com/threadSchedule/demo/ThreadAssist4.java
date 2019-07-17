package com.threadSchedule.demo;

public class ThreadAssist4 implements Runnable {
    public void run(){
        for(int i=1;i<1000000;i++){
            System.out.println("ThreadAssist4 线程第"+i+"次执行");
            try{
                Thread.sleep(10);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
