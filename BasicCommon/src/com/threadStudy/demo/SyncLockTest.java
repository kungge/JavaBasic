package com.threadStudy.demo;

/**
 * 同步与锁测试
 * 注：没测出来
 */
public class SyncLockTest implements Runnable {
    SyncLockAssist assist=new SyncLockAssist();

    public static void main(String[] args) {
        test1();
    }

    static void test1(){
        System.out.println("******************test1-start******************");

        SyncLockTest st=new SyncLockTest();
        Thread t1=new Thread(st,"Tread1");
        Thread t2=new Thread(st,"Tread2");

        t1.start();
        t2.start();

        System.out.println("******************test1-end******************");
    }

    private int minus(int n){
        return assist.minus(n);
    }

    @Override
    public void run() {
        for (int i=0;i<5;i++){
            minus(3000);
            try{
                Thread.sleep(100);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" m="+assist.getM());
        }
    }
}
