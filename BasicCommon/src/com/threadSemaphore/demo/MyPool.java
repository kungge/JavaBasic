package com.threadSemaphore.demo;

import java.util.concurrent.Semaphore;

public class MyPool {
    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    private Semaphore semaphore;

    public MyPool(int size){
        this.semaphore=new Semaphore(size);
    }

}
