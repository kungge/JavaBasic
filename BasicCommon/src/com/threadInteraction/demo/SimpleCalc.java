package com.threadInteraction.demo;


public class SimpleCalc extends Thread {
    int total;

    public void run(){

        System.out.println("SimpleCalc Start");

        synchronized (this){
            for (int i=0;i<10000;i++){
                total+=i;
            }

            System.out.println("SimpleCalc 已经完成计算了，开始 notifyAll()");

            notifyAll();

            System.out.println("SimpleCalc 完成 notifyAll()");
        }

        System.out.println("SimpleCalc End");
    }
}
