package com.threadSync.demo;

public class ThreadAssist extends Thread {
    private User u;
    private int y=0;

    public ThreadAssist(String name,User u,int y){
       super(name);
       this.u=u;
       this.y=y;
    }

    public void run(){
        u.oper(y);
    }
}
