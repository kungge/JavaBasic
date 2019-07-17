package com.threadInteraction.demo;

public class ThreadB extends Thread {
    int total;

    public void run(){
        synchronized (this){
            for(int i=0;i<10000;i++){
                total+=i;
            }
            System.out.println("ThreadB 已经完成计算了，开始 notify()");
            //（完成计算）唤醒在此对象监视器上等待的单个线程，本例中线程A被唤醒
            notify();
            System.out.println("ThreadB 完成 notify()");
        }
    }
}
