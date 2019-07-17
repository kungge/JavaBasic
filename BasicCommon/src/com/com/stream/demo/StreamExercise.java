package com.com.stream.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class StreamExercise {
    public static void main(String[] args) {
        String sourcePath="E:\\test\\javaFileTest\\test3\\test2.txt";
        String destPath="E:\\test\\javaFileTest\\test4\\test2bak.txt";
        fileMove(sourcePath,destPath);
    }

    static void fileMove(String sourPath,String destPath){

        try{
            FileInputStream inputStream=new FileInputStream(sourPath);
            FileOutputStream outputStream=new FileOutputStream(destPath);

            byte[] bytes=new byte[1024];
            int readLen=0;
            while ((readLen=inputStream.read(bytes))!=-1){
                System.out.println(readLen);
                outputStream.write(bytes,0,readLen);
            }

            outputStream.flush();
            outputStream.close();

            inputStream.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
}
