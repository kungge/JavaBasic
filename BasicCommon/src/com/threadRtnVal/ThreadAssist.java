package com.threadRtnVal;

import java.util.concurrent.Callable;

public class ThreadAssist implements Callable {
    private String oName;

    public ThreadAssist(String oName){
        this.oName=oName;
    }

    @Override
    public Object call() throws Exception {
        return oName+"任务返回的内容";
    }
}
