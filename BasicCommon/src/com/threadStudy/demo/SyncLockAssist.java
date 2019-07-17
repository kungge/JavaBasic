package com.threadStudy.demo;

/**
 * synchronized 同步方法或代码
 */
public class SyncLockAssist {
    private int m=10000;

//    public int getM(){
//        return m;
//    }

//    public synchronized int getM(){
//        return m;
//    }

        public int getM(){
        synchronized (this){
            return m;
        }

    }


//    public int minus(int n){
//        m=m-n;
//        return m;
//    }

    public int minus(int n){
        synchronized (this){
            m=m-n;
        }

        return m;
    }
    private String name;

// 静态方法同步
//    public synchronized String getName(String name){
//        this.name=name;
//    }

    public String getName(String name){
        synchronized (SyncLockAssist.class){
            this.name=name;
        }
        return this.name;
    }
}
