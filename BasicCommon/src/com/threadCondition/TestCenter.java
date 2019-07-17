package com.threadCondition;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 条件变量
 */
public class TestCenter {
    public static void main(String[] args) {
        test2();
    }

    /**
     * 使用条件变量
     */
    static void test1() {
        System.out.println("*************test1-start****************");

        BankAccount bankAccount=new BankAccount("9050901080001",10000);

        ExecutorService pool= Executors.newFixedThreadPool(2);

        Thread t1=new SaveThread("jack1",bankAccount,2000);
        Thread t2=new SaveThread("jack2",bankAccount,3000);
        Thread t3=new DrawThread("jack3",bankAccount,16000);
        Thread t4=new SaveThread("jack4",bankAccount,500);
        Thread t5=new DrawThread("jack5",bankAccount,4000);
        Thread t6=new SaveThread("jack6",bankAccount,8000);

        //执行各个线程
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);

        //关闭线程池
        pool.shutdown();

        System.out.println("*************test1-end****************");
    }

    /**
     * 不使用条件变量
     */
    static void test2() {
        System.out.println("*************test2-start****************");

        BankAccountV2 bankAccount=new BankAccountV2("9051301080001",10000);

        ExecutorService pool= Executors.newFixedThreadPool(2);

        Thread t1=new SaveThreadV2("jack1",bankAccount,2000);
        Thread t2=new SaveThreadV2("jack2",bankAccount,3000);
        Thread t3=new DrawThreadV2("jack3",bankAccount,16000);
        Thread t4=new SaveThreadV2("jack4",bankAccount,500);
        Thread t5=new DrawThreadV2("jack5",bankAccount,4000);
        Thread t6=new SaveThreadV2("jack6",bankAccount,8000);

        //执行各个线程
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);

        //关闭线程池
        pool.shutdown();

        System.out.println("*************test2-end****************");
    }
}
