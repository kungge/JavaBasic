package com.threadBarrier.demo;

import java.util.concurrent.CyclicBarrier;

/**
 * 障碍器测试
 */
public class TestCenter {
    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        System.out.println("*************test1-start****************");

        Runnable mainTask=new MainTask();
        CyclicBarrier cyclicBarrier=new CyclicBarrier(4,mainTask);

        Thread t1= new SubTask("Task1",cyclicBarrier);
        Thread t2= new SubTask("Task2",cyclicBarrier);
        Thread t3= new SubTask("Task3",cyclicBarrier);
        Thread t4= new SubTask("Task4",cyclicBarrier);

        t1.start();
        t2.start();
        t3.start();
        t4.start();


        System.out.println("*************test1-end****************");
    }
}
