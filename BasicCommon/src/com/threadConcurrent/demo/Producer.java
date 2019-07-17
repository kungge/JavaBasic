package com.threadConcurrent.demo;

/**
 * 生产者
 */
public class Producer extends Thread {
    private int needNum;
    private Godown godown;

    public Producer(int needNum,Godown godown){
        this.needNum=needNum;
        this.godown=godown;
    }

    public void run(){
        godown.produce(this.needNum);
    }
}
