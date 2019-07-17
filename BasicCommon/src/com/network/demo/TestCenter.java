package com.network.demo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP网络编程测试
 */
public class TestCenter {
    public static void main(String[] args) {
        test1();
    }

    /**
     * InetAddress类的使用
     */
    static void test1() {
        System.out.println("*************test1-start****************");

        try{
            InetAddress inet1=InetAddress.getByName("www.kungge.com");// 使用域名创建对象
            System.out.println("inet1="+inet1);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        try{
            InetAddress inet2=InetAddress.getByName("127.0.0.1");// 使用IP创建对象
            System.out.println("inet2="+inet2);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        try{
            InetAddress inet3=InetAddress.getLocalHost();//获得本机地址对象
            System.out.println("inet3="+inet3);
            System.out.println("getHostName="+inet3.getHostName());//获得对象中存储的域名
            System.out.println("ip="+inet3.getHostAddress());//获得对象中存储的ip
        }catch (Exception ex){
            ex.printStackTrace();
        }


        System.out.println("*************test1-end****************");
    }

    /**
     *简单的socket客户端
     */
    static void test2(){
        System.out.println("*************test2-start****************");

        Socket socket=null;
        OutputStream os=null;
        InputStream is=null;
        String ip="127.0.0.1";
        int port=10000;
        String msg="Hello World!";

        try{
            socket=new Socket(ip,port);

            os=socket.getOutputStream();
            os.write(msg.getBytes());

            is=socket.getInputStream();
            byte[] bytes=new byte[1024];
            int r=is.read(bytes);
            System.out.println("反馈："+new String(bytes,0,r));
        }catch (Exception ex){
        }finally {
            try{
                is.close();
                os.close();
                socket.close();
            }catch (Exception e){
            }
        }

        System.out.println("*************test2-end****************");
    }

    /**
     * 简单的socket服务端
     */
    static void test3(){
        System.out.println("*************test3-start****************");


        ServerSocket serverSocket=null;

        Socket socket=null;
        InputStream is=null;
        OutputStream os=null;
        int port=10000;

        try{

            serverSocket=new ServerSocket(port);
            socket=serverSocket.accept();

            is=socket.getInputStream();
            byte[] bytes=new byte[1024];
            int r=is.read(bytes);
            System.out.println("服务器得到："+new String(bytes,0,r));

            os=socket.getOutputStream();
            String msg="你好，我收到了你的消息";
            os.write(msg.getBytes());

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                os.close();
                is.close();
                socket.close();
                serverSocket.close();
            }catch (Exception e){
            }
        }

        System.out.println("*************test3-end****************");
    }

    /**
     *复用连接的socket客户端
     */
    static void test4(){
        System.out.println("*************test4-start****************");

        Socket socket=null;
        OutputStream os=null;
        InputStream is=null;
        String ip="127.0.0.1";
        int port=10000;

        String msgs[]={"msg1","msg2","msg3"};

        try{
            socket=new Socket(ip,port);

            os=socket.getOutputStream();
            is=socket.getInputStream();

            byte[] bytes=new byte[1024];

            for (int i=0;i<msgs.length;i++){
                os.write(msgs[i].getBytes());

                int r=is.read(bytes);

                System.out.println("反馈："+new String(bytes,0,r));
            }

        }catch (Exception ex){
        }finally {
            try{
                is.close();
                os.close();
                socket.close();
            }catch (Exception e){
            }
        }

        System.out.println("*************test4-end****************");
    }

    /**
     * 复用连接的socket服务端
     */
    static void test5(){
        System.out.println("*************test5-start****************");

        ServerSocket serverSocket=null;

        Socket socket=null;
        InputStream is=null;
        OutputStream os=null;
        int port=10000;

        try{

            serverSocket=new ServerSocket(port);
            socket=serverSocket.accept();

            is=socket.getInputStream();
            os=socket.getOutputStream();

            byte[] bytes=new byte[1024];

            for(int i=0;i<3;i++){
                int r=is.read(bytes);
                String getMsg=new String(bytes,0,r);
                System.out.println("服务器得到："+getMsg);

                String msg="你好，我收到了你的消息："+getMsg;
                os.write(msg.getBytes());
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                os.close();
                is.close();
                socket.close();
                serverSocket.close();
            }catch (Exception e){
            }
        }

        System.out.println("*************test5-end****************");
    }

    /**
     * 支持多客户端的服务器端实现
     */
    static void test6(){

        System.out.println("*************test6-start****************");

        ServerSocket serverSocket=null;

        Socket socket=null;
        InputStream inputStream=null;
        OutputStream outputStream=null;
        int port=10000;

        try{
            serverSocket=new ServerSocket(port);

            System.out.println("服务器已启动");

            while (true){
                socket=serverSocket.accept();
                LogicThread logicThread=new LogicThread(socket);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                serverSocket.close();
            }catch (Exception e){}
        }

        System.out.println("*************test6-end****************");
    }

}
