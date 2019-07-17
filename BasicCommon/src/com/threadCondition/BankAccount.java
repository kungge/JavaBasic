package com.threadCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行账户
 */
public class BankAccount {
    private String account;
    private int balance;

    private Lock lock=new ReentrantLock();//账户锁
    private Condition saveCondition=lock.newCondition();//存款条件
    private Condition drawCondition=lock.newCondition();//取款条件

    public BankAccount(String account,int balance){
        this.account=account;
        this.balance=balance;
    }

    /**
     * 存款
     * @param x
     * @param name
     */
    public void saving(int x,String name){
        lock.lock();//获取锁
        if(x>0){
            balance+=x;
            System.out.println(name+"存款["+x+"]操作，账户["+account+"]余额["+balance+"]");
        }
        drawCondition.signalAll();//唤醒所有等待线程
        lock.unlock();//释放锁
    }

    /**
     * 取款
     * @param x
     * @param name
     */
    public void drawing(int x,String name){
        lock.lock();
        try{
            if(x>balance){
                System.out.println(name+"取款["+x+"]金额大于用户["+account+"]余额["+balance+"]，阻塞取款操作");
                drawCondition.await();//阻塞取款操作
            } else{
                balance-=x;
                System.out.println(name+"取款["+x+"]操作，账户["+account+"]余额["+balance+"]");
            }
            saveCondition.signalAll();//唤醒所有存款操作
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
