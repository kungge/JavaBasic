package com.threadConcurrent.demo;

/**
 * 仓库
 */
public class Godown {
    private static final int maxSize=100;
    private int current=0;

    public Godown(){}

    public Godown(int num){
        this.current=num;
    }

    /**
     * 生产
     * @param num
     */
    public synchronized void produce(int num){
        while (current+num>maxSize){
            System.out.println("Godown produce 当前库存["+this.current+"]，加上生产的数量["+num+"]大于最大容量，等待");

            try {
                wait();
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }

        }
        this.current+=num;
        System.out.println("Godown produce 已经生产了["+num+"]，当前库存量["+this.current+"]");
        notifyAll();
    }

    /**
     * 消费
     * @param num
     */
    public synchronized void consume(int num){
        while(current<num){
            System.out.println("Godown consume 当前库存["+this.current+"]小于消费的数量["+num+"]，等待");

            try {
                wait();
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        this.current-=num;
        System.out.println("Godown consume 已经消费了["+num+"]，当前库存量["+this.current+"]");
        notifyAll();
    }
}
