package com.file.demo;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileExercise {
    public static void main(String[] args) {
        String sourcePath="E:\\test\\kuaishou";
        String destPath="F:\\life\\kuaishoubak";
        fileMove(sourcePath,destPath);
    }

    static void fileMove(String sourPath,String destPath){
        File dest=new File(destPath);
        if(!dest.exists()){
            dest.mkdirs();
        }
        if(dest.isDirectory()){
            if(!dest.exists()){
                dest.mkdirs();
            }
        }
        File source=new File(sourPath);
        if(source.isDirectory()){
           File[] files= source.listFiles();
            if(files!=null && files.length>0){
                for (File f:files){
                    if(f.isFile()){
                        oneFileMove(f,destPath);
                    }else{
                        fileMove(f.getAbsolutePath(),destPath+"\\"+f.getName());
                    }
                }
            }
        }else{
            oneFileMove(source,destPath);
        }
    }

    static void oneFileMove(File source,String destPath){
        try{
            String fileName=source.getName();
            String destName=destPath+"\\"+fileName;

            FileInputStream inputStream=new FileInputStream(source);
            FileOutputStream outputStream=new FileOutputStream(destName);

            byte[] bytes=new byte[1024];
            int readLen=0;
            while((readLen=inputStream.read(bytes,0,bytes.length))!=-1){
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
