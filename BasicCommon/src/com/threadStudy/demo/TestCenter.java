package com.threadStudy.demo;

public class TestCenter {
    public static void main(String[] args) {
        // test1();

        test2();
    }

    static void test1(){

        System.out.println("******************test1-start******************");

        TestRunnable r1=new TestRunnable("Jack");
        TestRunnable r2=new TestRunnable("Tom");

        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);

        t1.start();
        t2.start();

        System.out.println("******************test1-end******************");
    }

    static void test2(){

        System.out.println("******************test2-start******************");

        Thread t1=new TestThread("Mark");
        Thread t2=new TestThread("Lily");

        t1.start();// TODO 没反应？？
        t2.start();

        TestThread tt1=new TestThread("Bomb");
        tt1.start();


        System.out.println("******************test2-end******************");
    }

}
