package com.threadRtnVal;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 有返回值的线程
 */
public class TestCenter {
    public static void main(String[] args) {
        try{
            test1();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    static void test1() throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Callable c1 = new ThreadAssist("A");
        Callable c2 = new ThreadAssist("B");

        Future f1 = pool.submit(c1);
        Future f2 = pool.submit(c2);

        System.out.println(f1.get().toString());
        System.out.println(f2.get().toString());
    }
}
