package com.threadStudy.demo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SyncLockAssist2 {
    private List<Object> nameList= Collections.synchronizedList(new LinkedList());

    public void add(String name){
        nameList.add(name);
    }
     public String removeFirst(){

      if(nameList.size()>0){
            return (String)nameList.remove(0);
        }else{
            return null;
        }
    }
}
