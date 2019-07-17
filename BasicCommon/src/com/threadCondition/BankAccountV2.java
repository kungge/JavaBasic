package com.threadCondition;

/**
 * 银行账户
 */
public class BankAccountV2 {
    private String account;
    private int balance;

    public BankAccountV2(String account,int balance){
        this.account=account;
        this.balance=balance;
    }

    /**
     * 存款 (同步方法)
     * @param x
     * @param name
     */
//    public synchronized void saving(int x,String name) {
//        if(x>0){
//            balance+=x;
//            System.out.println(name+"存款["+x+"]操作，账户["+account+"]余额["+balance+"]");
//        }
//        notifyAll();//唤醒所有等待的线程
//    }

    /**
     * 存款 (同步代码块)
     * @param x
     * @param name
     */
    public void saving(int x,String name) {
        if(x>0){
            synchronized (this){
                balance+=x;
                System.out.println(name+"存款["+x+"]操作，账户["+account+"]余额["+balance+"]");
                notifyAll();//唤醒所有等待的线程
            }
        }
    }

    /**
     * 取款 (同步方法)
     * @param x
     * @param name
     */
//    public synchronized void drawing(int x,String name){
//        if(x>balance){
//            try{
//                System.out.println(name+"取款["+x+"]金额大于用户["+account+"]余额["+balance+"]，等待");
//                wait();
//            }catch (InterruptedException ex){
//                ex.printStackTrace();
//            }
//        } else{
//            balance-=x;
//            System.out.println(name+"取款["+x+"]操作，账户["+account+"]余额["+balance+"]");
//        }
//        notifyAll();//唤醒所有存款操作
//    }

    /**
     * 取款（同步代码块）
     * @param x
     * @param name
     */
    public synchronized void drawing(int x,String name){
        synchronized (this){
            if(x>balance){
                try{
                    System.out.println(name+"取款["+x+"]金额大于用户["+account+"]余额["+balance+"]，等待");
                    wait();
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            } else{
                balance-=x;
                System.out.println(name+"取款["+x+"]操作，账户["+account+"]余额["+balance+"]");
            }
        }
        notifyAll();//唤醒所有存款操作
    }

}
