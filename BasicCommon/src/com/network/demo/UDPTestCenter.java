package com.network.demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * UDP网络编程测试
 */
public class UDPTestCenter {
    public static void main(String[] args) {
        test1();
    }

    /**
     * 简单的UDP客户端，实现向服务器发送消息
     */
    static void test1(){
        System.out.println("*************test1-start****************");

        DatagramSocket datagramSocket=null;//连接对象
        DatagramPacket datagramPacket_send=null;//发送数据包对象
        DatagramPacket datagramPacket_receive=null;//接收数据包对象

        String ip="127.0.0.1";//服务器ip
        int port=10010;//服务器端口号

        try{
            InetAddress inetAddress=InetAddress.getByName(ip);

            datagramSocket=new DatagramSocket(port,inetAddress);

            //发送数据
            String msg= "Hello World";

            byte[] data=msg.getBytes();

            datagramPacket_send=new DatagramPacket(data,data.length,inetAddress,port);
            datagramSocket.send(datagramPacket_send);//发送

            //接收数据
            byte[] b=new byte[1024];
            datagramPacket_receive=new DatagramPacket(b,b.length);
            datagramSocket.receive(datagramPacket_receive);
            byte[] response=datagramPacket_receive.getData();
            int len=datagramPacket_receive.getLength();
            String str=new String(response,0,len);

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            datagramSocket.close();
        }

        System.out.println("*************test1-end****************");
    }

    /**
     * 简单的UDP服务器端，实现向客户端发送消息
     */
    static void test2(){
        System.out.println("*************test2-start****************");

        DatagramSocket datagramSocket=null;
        DatagramPacket datagramPacket_receive=null;
        DatagramPacket datagramPacket_send=null;

        int port=10010;

        try{
            datagramSocket=new DatagramSocket(port);

            //接收
            byte[] b=new byte[1024];
            datagramPacket_receive=new DatagramPacket(b,b.length);
            datagramSocket.receive(datagramPacket_receive);
            byte[] resp=datagramPacket_receive.getData();
            int len=datagramPacket_receive.getLength();
            String msg_receive=new String(resp,0,len);

            InetAddress inetAddress_client=datagramPacket_receive.getAddress();
            int port_clint=datagramPacket_receive.getPort();

            //发送
            String msg_send="我收到了你的信息："+msg_receive;
            byte[] b_send=msg_send.getBytes();
            datagramPacket_send=new DatagramPacket(b_send,b_send.length,inetAddress_client,port_clint);
            datagramSocket.send(datagramPacket_send);

        }
        catch (Exception ex){
            ex.printStackTrace();
        }finally {
            datagramSocket.close();
        }

        System.out.println("*************test2-end****************");
    }
}
