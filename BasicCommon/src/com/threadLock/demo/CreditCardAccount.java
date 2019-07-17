package com.threadLock.demo;

/**
 * 信用卡账户
 */
public class CreditCardAccount {
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    private String account;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    private int balance;

    public CreditCardAccount(String account,int balance){
        this.account=account;
        this.balance=balance;
    }

    @Override
    public String toString(){
        return "CreditCardAccount["+account+","+balance+"]";
    }


}
