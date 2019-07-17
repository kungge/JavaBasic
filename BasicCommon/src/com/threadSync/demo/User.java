package com.threadSync.demo;

/**
 * 测试线程同步
 */
public class User {
    private String code;
    private int cash;

   public User(String code,int cash){
       this.code=code;
       this.cash=cash;
   }

    /**
     * 同步方法
     * @param x
     */
   public synchronized void oper(int x){
       try{
           this.cash+=x;
           System.out.println("User "+Thread.currentThread().getName()+",增加"+x+"，当前用户["+this.code+"]余额="+this.cash);
           Thread.sleep(10L);
       }catch (InterruptedException ex){
           ex.printStackTrace();
       }
   }

    /**
     * 同步代码
     * @param x
     */
    public void oper2(int x){
        try{
            synchronized(this){
                this.cash+=x;
                System.out.println("User "+Thread.currentThread().getName()+",增加"+x+"，当前用户["+this.code+"]余额="+this.cash);
            }
            Thread.sleep(10L);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

   @Override
   public String toString(){
       return "User[code="+this.code+",cash="+this.cash+"]";
   }
}
