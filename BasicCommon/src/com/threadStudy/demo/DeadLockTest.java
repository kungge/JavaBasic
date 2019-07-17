package com.threadStudy.demo;

/**
 * 线程死锁测似
 */
public class DeadLockTest {
    public static class Resource{
        public int value;
    }

    private Resource resource1=new Resource();
    private Resource resource2=new Resource();

    public int read(){
        synchronized (resource1){
            synchronized (resource2){
                return resource1.value+resource2.value;
            }
        }
    }

    public void write(int m,int n){
        synchronized (resource2){
            synchronized (resource1){
                resource1.value=m;
                resource2.value=n;
            }
        }
    }
}
