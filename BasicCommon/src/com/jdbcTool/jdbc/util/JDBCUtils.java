package com.jdbcTool.jdbc.util;

import com.jdbcTool.jdbc.enums.DriverInfoEnum;

/**
 * JDBC工具类
 */
public class JDBCUtils {

    //加载驱动
    static{
        try{
            Class.forName(DriverInfoEnum.DRIVER_CLASS.getInfo());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test1();
    }

    static  void test1(){
        System.out.println("************tets1-start********************\r");

        System.out.println(DriverInfoEnum.DRIVER_CLASS.getInfo());

        System.out.println("************tets1-end********************\r");
    }


}
