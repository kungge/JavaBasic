package com.threadSchedule.demo;

/**
 * 线程调度
 */
public class ThreadTest {
    public static void main(String[] args) {
        test5();
    }

    /**
     * 休眠测试
     */
    static void test1(){

        System.out.println("*************test1-start****************");

        Thread t1=new ThreadSleepAssist();
        Thread t2=new Thread(new ThreadSleepAssist2());

        t1.start();
        t2.start();

        System.out.println("*************test1-end****************");
    }

    /**
     * 优先级测试
     */
    static void test2(){
        System.out.println("*************test2-start****************");

        Thread t1=new ThreadSleepAssist();
        Thread t2=new Thread(new ThreadSleepAssist2());

        t1.setPriority(10);
        t2.setPriority(1);

        t1.start();
        t2.start();

        System.out.println("*************test2-end****************");
    }

    /**
     * 线程让步测试
     */
    static void test3(){

        System.out.println("*************test3-start****************");

        Thread t1=new ThreadAssist1();
        Thread t2=new Thread(new ThreadAssist2());

        t1.start();
        t2.start();

        System.out.println("*************test3-end****************");
    }

    /**
     * 线程合并测试
     */
    static void test4(){
        System.out.println("*************test4-start****************");

        Thread t1=new ThreadAssist3();
        t1.start();

        for(int i=1;i<15;i++){
            System.out.println("test4 主线程第"+i+"次执行");
            if(i>3){
                try{
                    //t1线程合并到主线程中，主线程停止执行过程，转而执行t1线程，直到t1执行完毕后继续
                    t1.join();
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        }

        System.out.println("*************test4-end****************");
    }

    /**
     * 守护线程测试
     */
    static void test5(){
        System.out.println("*************test5-start****************");

        Thread t1=new ThreadAssist3();
        Thread t2=new Thread(new ThreadAssist4());

        t2.setDaemon(true);//设置为守护线程

        t2.start();
        t1.start();


        System.out.println("*************test5-end****************");
    }

}
