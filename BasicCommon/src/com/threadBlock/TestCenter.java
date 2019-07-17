package com.threadBlock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 阻塞
 */
public class TestCenter {
    public static void main(String[] args) {
        test2();
    }

    /**
     * 阻塞队列
     */
    static void test1()  {
        System.out.println("*************test1-start****************");

        BlockingQueue blockingQueue=new ArrayBlockingQueue(20);
        for(int i=0;i<30;i++){
            try{
                blockingQueue.put(i);
                System.out.println("向阻塞队列中添加"+i);
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }

        }

        System.out.println("*************test1-end****************");
    }

    /**
     * 阻塞栈
     */
    static void test2()  {
        System.out.println("*************test2-start****************");

        LinkedBlockingDeque blockingDeque=new LinkedBlockingDeque(20);
        for(int i=0;i<30;i++){
            try{
                blockingDeque.putFirst(i);
                System.out.println("向阻塞栈中添加"+i);
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }

        System.out.println("*************test2-end****************");
    }
}
