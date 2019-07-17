package com.threadStudy.demo;

/**
 * 扩展 Thread 类实现多线程
 */
public class TestThread extends Thread {
    public TestThread(String name){
        super(name);
    }

    public void Run(){
        for(int i=0;i<5;i++){
            for(int j=0;j<1000000000;j++);// 模拟耗时操作
            System.out.println(this.getName()+":"+i);
        }
    }
}
