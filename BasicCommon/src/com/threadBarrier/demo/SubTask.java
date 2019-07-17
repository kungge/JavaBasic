package com.threadBarrier.demo;

import java.util.concurrent.CyclicBarrier;

/**
 * 子任务
 */
public class SubTask extends Thread {
    private String taskName;
    private CyclicBarrier cyclicBarrier;

    public SubTask(String taskName,CyclicBarrier cyclicBarrier){
        this.taskName=taskName;
        this.cyclicBarrier=cyclicBarrier;
    }

    public void run(){
        System.out.println("子任务["+taskName+"]开始执行");
        for(int i=0;i<1000000;i++);//模拟耗时的任务
        System.out.println("子任务["+taskName+"]执行完成，并通知障碍器已经完成");
        try{
            //通知障碍器已经完成
            cyclicBarrier.await();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
