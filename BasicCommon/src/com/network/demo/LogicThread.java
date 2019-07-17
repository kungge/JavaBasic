package com.network.demo;

import sun.rmi.runtime.Log;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 服务器端逻辑线程
 */
public class LogicThread extends Thread {

    Socket socket;
    InputStream inputStream;
    OutputStream outputStream;

    public LogicThread(Socket socket){
        this.socket=socket;
        start();
    }

    public void run(){
        try{
            inputStream=socket.getInputStream();
            outputStream=socket.getOutputStream();

            byte[] bytes=new byte[1024];

            for(int i=0;i<3;i++){
                int r=inputStream.read(bytes);
                byte[] response=logic(bytes,0,r);
                outputStream.write(response);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            close();
        }
    }

    private void close(){
        try{
            outputStream.close();
            inputStream.close();
            socket.close();
        }catch (Exception e){}
    }

    /**
     * 逻辑处理方法，实现echo逻辑
     * @param bytes
     * @param off
     * @param len
     * @return
     */
    private byte[] logic(byte[] bytes,int off,int len){
        byte[] response=new byte[len];
        System.arraycopy(bytes,0,response,0,len);
        return response;
    }
}
