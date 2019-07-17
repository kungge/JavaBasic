package com.threadCondition;

/**
 * 存款线程
 */
public class SaveThreadV2 extends Thread{
    public String name;//操作人
    public BankAccountV2 bankAccount;
    public int x;

    public SaveThreadV2(String name,BankAccountV2 bankAccount,int x){
        this.name=name;
        this.bankAccount=bankAccount;
        this.x=x;
    }

    public void run(){
        bankAccount.saving(x,name);
    }
}
