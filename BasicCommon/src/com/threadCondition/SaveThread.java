package com.threadCondition;

/**
 * 存款线程
 */
public class SaveThread extends Thread {
    public String name;//操作人
    public BankAccount bankAccount;
    public int x;

    public SaveThread(String name,BankAccount bankAccount,int x){
        this.name=name;
        this.bankAccount=bankAccount;
        this.x=x;
    }

    public void run(){
        bankAccount.saving(x,name);
    }
}
