package com.theJdbc.demo;

import java.sql.*;

/**
 * jdbc测试
 * @referUrl http://www.kungge.com/gooditblog/3802.html
 */
public class TestCenter {
    public static void main(String[] args) {
        test1();
    }

    static void test1(){
        System.out.println("*************test1-start****************");

        Connection connection=null;
        Statement statement=null;

        try{
            Class.forName("com.mysql.jdbc.Drive");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqltest","root","1234567a");
            connection.setAutoCommit(false);//设置手动提交
            statement= connection.createStatement();
            String id="8";
            String sql="delete from t_user where id="+id;
            statement.executeQuery(sql);

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                if(statement!=null){
                    statement.close();
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }finally {
                try{
                    if(connection!=null){
                        connection.close();
                    }
                }catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        }

        System.out.println("*************test1-end****************");
    }

    static void test2(){
        System.out.println("*************test2-start****************");

        Connection conn=null;
        PreparedStatement statement=null;

        try{
            Class.forName("com.mysql.jdbc.Drive");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqltest","root","1234567a");

            conn.setAutoCommit(false);//设置手动提交

            String sql="insert into t_user(name,age) values(?,?)";


            statement= conn.prepareStatement(sql);
            statement.setString(1,"张三");
            statement.setInt(2,32);

            statement.executeQuery();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                if(statement!=null){
                    statement.close();
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }finally {
                try{
                    if(conn!=null){
                        conn.close();
                    }
                }catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        }

        System.out.println("*************test2-end****************");
    }
}
