package com.threadInteraction.demo;

/**
 *线程的交互
 */
public class ThreadA {
    public static void main(String[] args) {
        ThreadB threadB=new ThreadB();
        threadB.start();

        synchronized (threadB){
            try{
                System.out.println("TheadA 等待B对象完成计算");
                threadB.wait();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            System.out.println("TheadA B对象计算的总和="+threadB.total);
        }

        System.out.println("the end");
    }
}
