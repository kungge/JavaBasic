package com.threadInteraction.demo;

/**
 * 线程交互测试
 */
public class ReadCalcResult extends Thread {
    SimpleCalc sc;

    public ReadCalcResult(SimpleCalc sc){
        this.sc=sc;
    }

    public void run(){
        synchronized (sc){
            try{
                System.out.println(Thread.currentThread()+" ReadCalcResult 等待计算结果...");
                sc.wait();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread()+" ReadCalcResult 计算结果="+sc.total);
        }
    }

    public static void main(String[] args) {
        SimpleCalc sc=new SimpleCalc();

        //启动3个线程，分别获取计算结果
       Thread t1= new ReadCalcResult(sc);
        Thread t2= new ReadCalcResult(sc);
        Thread t3= new ReadCalcResult(sc);
        t1.start();
        t2.start();
        t3.start();

        sc.start();
    }
}
