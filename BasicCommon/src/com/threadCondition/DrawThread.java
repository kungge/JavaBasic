package com.threadCondition;

/**
 * 取款线程
 */
public class DrawThread extends Thread {
    public String name;//操作人
    public BankAccount bankAccount;
    public int x;

    public DrawThread(String name,BankAccount bankAccount,int x){
        this.name=name;
        this.bankAccount=bankAccount;
        this.x=x;
    }

    public void run(){
        bankAccount.drawing(x,name);
    }
}
