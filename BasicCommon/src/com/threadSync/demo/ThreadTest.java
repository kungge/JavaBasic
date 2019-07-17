package com.threadSync.demo;

/**
 * 线程同步
 */
public class ThreadTest {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 线程同步-同步方法
     */
    static void test1(){
        System.out.println("*************test1-start****************");

        User u=new User("Jack",100);

        ThreadAssist t1=new ThreadAssist("线程1",u,20);
        ThreadAssist t2=new ThreadAssist("线程2",u,-60);
        ThreadAssist t3=new ThreadAssist("线程3",u,-80);
        ThreadAssist t4=new ThreadAssist("线程4",u,-30);
        ThreadAssist t5=new ThreadAssist("线程4",u,30);
        ThreadAssist t6=new ThreadAssist("线程4",u,20);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        System.out.println("*************test1-end****************");
    }
}
