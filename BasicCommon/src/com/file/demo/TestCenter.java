package com.file.demo;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestCenter {
    public static void main(String[] args) {
        test1();

//        String path="E:\\test";
//        test2(path);

//        test3();
//        test4();
    }

    /**
     * 列出一个目录下的文件
     */
    static void test1(){
        String path="E:\\test";
        File dir=new File(path);

        System.out.println("---------列出一个目录下所有的文件或目录：");
        File[] files=dir.listFiles();
        if(files!=null && files.length>0){
            for(File file : files){
                System.out.println(file.getAbsolutePath()+" 文件="+file.isFile()+" 目录="+file.isDirectory());
            }
        }

        System.out.println("---------列出一个目录下list()：");
        String[] strs=dir.list();
        for (String s : strs){
            System.out.println(s);
        }
    }

    /**
     * 递归列出所有文件
     * @param path
     */
    static void test2(String path){
        File dir=new File(path);
        File[] files=dir.listFiles();
        if(files!=null && files.length>0){
            for(File file : files){
                if(file.isFile()){
                    System.out.println(file.getAbsolutePath());
                }else{
                    test2(file.getAbsolutePath());
                }
            }
        }
    }

    /**
     * 创建目录、文件
     */
    static void test3(){
        File file=new File("E:\\test\\javaFileTest\\test1\\a\\b\\c\\123.txt");
        if(file.exists()){
            System.out.println(file+" 存在");
        }else{
            System.out.println(file+" 不存在");

            String parent=file.getParent();
            System.out.println(file+" getParent()="+parent);

            File dir=new File(parent);
            if(!dir.exists()){
                System.out.println(dir+" 不存在，开始创建目录");
                dir.mkdir();// 创建一级目录
                //dir.mkdirs();//创建多级目录
            }
        }

        try{
            //创建文件
            System.out.println("开始创建文件 "+file.getName());
            boolean b=file.createNewFile();
            System.out.println("创建文件完成，创建"+(b?"成功":"失败"));
        }catch (IOException ex){
            System.out.println("创建文件出现异常");
            ex.printStackTrace();
        }

        //删除文件（注：目录为空才能删除）
        file.delete();

    }

    /**
     * 获取文件属性
     */
    static void test4(){
        File file=new File("E:\\test\\javaFileTest\\test1\\a\\b\\c\\abc.txt");
        if(file.exists()){
            System.out.println("文件名称："+file.getName());
            System.out.println("文件路径："+file.getAbsolutePath());
            System.out.println("文件大小："+file.length());
            System.out.println("文件是否可读："+file.canRead()+" 是否可写："+file.canWrite());
            System.out.println("文件最后修改时间："+new Date(file.lastModified()));
            System.out.println("文件是否隐藏："+file.isHidden());
        }
    }


}
