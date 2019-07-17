package com.threadLock.demo;

import java.util.concurrent.locks.Lock;

/**
 * 信用卡用户
 */
public class CreditCardUser implements Runnable {
    private String name;
    private CreditCardAccount creditCardAccount;
    private int processCash;
    private Lock theLock;

    public CreditCardUser(String name, CreditCardAccount creditCardAccount, int processCash, Lock theLock) {
        this.name = name;
        this.creditCardAccount = creditCardAccount;
        this.processCash = processCash;
        this.theLock = theLock;
    }

    public void run(){
        //获得锁
        theLock.lock();
        System.out.println("CreditCardUser 开始操作用户["+name+"]账户"+creditCardAccount+"金额["+processCash+"]，余额["+creditCardAccount.getBalance()+"]");
creditCardAccount.setBalance(creditCardAccount.getBalance()+processCash);
        System.out.println("CreditCardUser 操作用户["+name+"]账户"+creditCardAccount+"金额["+processCash+"]完成， 余额["+creditCardAccount.getBalance()+"]");
        //释放锁
        theLock.unlock();
    }
}
