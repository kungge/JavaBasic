package com.threadLock.demo;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * 信用卡用户
 */
public class CreditCardUserV2 implements Runnable {
    private String name;
    private CreditCardAccount creditCardAccount;
    private int processCash;
    private ReadWriteLock theLock;
    private boolean isQuery;

    public CreditCardUserV2(String name, CreditCardAccount creditCardAccount, int processCash, ReadWriteLock theLock,boolean isQuery) {
        this.name = name;
        this.creditCardAccount = creditCardAccount;
        this.processCash = processCash;
        this.theLock = theLock;
        this.isQuery=isQuery;
    }

    public void run(){
        if(isQuery){
            //获取读锁
            theLock.readLock().lock();
            System.out.println("CreditCardUserV2 查询用户["+name+"]账户"+creditCardAccount+"，余额["+creditCardAccount.getBalance()+"]");
            //释放读锁
            theLock.readLock().unlock();
        }
        else{
            //获得写锁
            theLock.writeLock().lock();
            System.out.println("CreditCardUserV2 开始操作用户["+name+"]账户"+creditCardAccount+"金额["+processCash+"]，余额["+creditCardAccount.getBalance()+"]");
            creditCardAccount.setBalance(creditCardAccount.getBalance()+processCash);
            System.out.println("CreditCardUserV2 操作用户["+name+"]账户"+creditCardAccount+"金额["+processCash+"]完成， 余额["+creditCardAccount.getBalance()+"]");
            //释放写锁
            theLock.writeLock().unlock();
        }

    }
}
