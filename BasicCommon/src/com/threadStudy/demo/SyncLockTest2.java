package com.threadStudy.demo;

/**
 * 线程安全类测试
 */
public class SyncLockTest2 {
    public static void main(String[] args) {
        final SyncLockAssist2 list=new SyncLockAssist2();
        list.add("jack");
        class AssistTest extends Thread{
            public void run(){
                String name=list.removeFirst();
                System.out.println(name);
            }
        }

        Thread t1=new AssistTest();
        Thread t2=new AssistTest();
        t1.start();
        t2.start();
    }
}
