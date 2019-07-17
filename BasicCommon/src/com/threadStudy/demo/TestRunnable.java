package com.threadStudy.demo;

/**
 * 实现 Runnable 接口的多线程
 */
public class TestRunnable implements Runnable {
    private String name;
    public TestRunnable(String name){
        this.name=name;
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            for(int j=0;j<1000000000;j++);// 模拟耗时操作
            System.out.println(name+":"+i);
        }
    }
}
