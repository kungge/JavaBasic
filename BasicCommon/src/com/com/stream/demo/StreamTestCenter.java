package com.com.stream.demo;

import java.io.*;

public class StreamTestCenter {
    public static void main(String[] args) {
        //test2();
        //test3();
        test4();
    }

    /**
     * 字节输出流写入文件内容
     */
    static void test1(){
        File file=new File("E:\\test\\javaFileTest\\test2\\a\\b","test1.txt");
        try{
            FileOutputStream stream=new FileOutputStream(file);
            String content="YL is my wife";
            byte[] bytes=content.getBytes();
            stream.write(bytes);

            stream.flush();
            stream.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    /**
     * 字节输入流读取文件内容
     */
    static void test2(){
        File file=new File("E:\\test\\javaFileTest\\test2\\a\\b","test2.txt");

        try{
            FileInputStream stream =new FileInputStream(file);

            int byteCount=stream.available();
            System.out.println("可用字节数："+byteCount);

            byte[] bytes=new byte[byteCount];
            stream.read(bytes,0,bytes.length);

            String content=new String(bytes,"GBK");
            System.out.println(content);

            stream.close();

        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

    /**
     * 字符输出流
     */
    static void test3(){
        try{
            FileWriter fileWriter=new FileWriter("E:\\test\\javaFileTest\\test2\\a\\b\\test3.txt",true);
            fileWriter.write("FileWriter write方法写入的内容");

            fileWriter.flush();
            fileWriter.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * 字符输入流读取文件内容
     */
    static void test4(){
        File file=new File("E:\\test\\javaFileTest\\test2\\a\\b\\test3.txt");
        try{
            FileReader reader=new FileReader(file);
            char[] chars=new char[(int)file.length()];
            reader.read(chars, 0, chars.length);

            String content=new String(chars);
            System.out.println(content);

            reader.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
