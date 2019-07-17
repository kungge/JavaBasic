package com.threadConcurrent.demo;

/**
 * 消费者
 */
public class Consumer extends Thread {
    private int needNum;
    private Godown godown;

    public Consumer(int needNum,Godown godown){
        this.needNum=needNum;
        this.godown=godown;
    }

    public void run(){
        godown.consume(this.needNum);
    }
}
