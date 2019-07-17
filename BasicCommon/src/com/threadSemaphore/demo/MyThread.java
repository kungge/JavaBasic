package com.threadSemaphore.demo;

public class MyThread extends Thread {
    private String threadName;
    private MyPool myPool;
    private int m;//信号量大小

    public MyThread(String threadName, MyPool myPool, int m) {
        this.threadName = threadName;
        this.myPool = myPool;
        this.m = m;
    }

    public void run() {
        try {
            //从此信号量获取给定数目的许可
            myPool.getSemaphore().acquire(m);
            //todo：也许这里可以做更复杂的业务
            System.out.println("MyThread "+threadName+"成功获取了"+m+"个许可");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }finally {
            myPool.getSemaphore().release(m);
            System.out.println("MyThread "+threadName+"释放了"+m+"个许可");
        }

    }
}
