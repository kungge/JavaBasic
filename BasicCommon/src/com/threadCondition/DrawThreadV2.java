package com.threadCondition;

/**
 * 取款线程
 */
public class DrawThreadV2 extends Thread {
    public String name;//操作人
    public BankAccountV2 bankAccount;
    public int x;

    public DrawThreadV2(String name,BankAccountV2 bankAccount,int x){
        this.name=name;
        this.bankAccount=bankAccount;
        this.x=x;
    }

    public void run(){
        bankAccount.drawing(x,name);
    }
}
