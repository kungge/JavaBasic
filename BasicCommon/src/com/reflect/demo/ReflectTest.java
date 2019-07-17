package com.reflect.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class ReflectTest {
    public static void main(String[] args) {
//        getClassName();

        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }


    /**
     * 通过一个对象获得完整的包名和类名
     */
/*    static void getClassName(){
        Person p=new Person();
        System.out.println(p.getClass().getName());
    }*/

    /**
     * 实例化Class对象
     */
    static void test1(){
       Class<?> p1 = null;
        Class<?> p2 = null;
        Class<?> p3 = null;
       try{
           p1=Class.forName("com.reflect.demo.Person");
       }catch (Exception ex){
           ex.printStackTrace();
       }

        p2=new Person().getClass();
        p3=Person.class;

        System.out.println("test1 输出类名：");
        System.out.println(p1.getName());
        System.out.println(p2.getName());
        System.out.println(p3.getName());
    }

    /**
     * 通过class实例化其它类对象
     */
    static void test2(){
        Class<?> p1 = null;
        try{
            p1=Class.forName("com.reflect.demo.Person");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        Person p2=null;

        try{
            p2=(Person)p1.newInstance();// 通过无参构造实例化对象。自己定义类的时候，如果定义了有参构造函数，注意也要定义一个无参构造函数，否则的话这里会报错
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        p2.setName("jack");
        p2.setAge(28);
        System.out.println("test2 输出：");
        System.out.println(p2);

    }

    /**
     * 通过class调用其他类中的构造函数
     */
    static void test3(){
        Class<?> p=null;
        try{
            p=Class.forName("com.reflect.demo.Person");
        }catch (Exception ex){
            ex.printStackTrace();
        }

        Person p1=null;
        Person p2=null;
        Person p3=null;
        Person p4=null;
        Constructor<?>[] cons =p.getConstructors();

        System.out.println("test3 输出所有的构造函数：");
        for(int i=0;i<cons.length;i++){
            System.out.println(cons[i]);
        }

        try{
            p1=(Person)cons[0].newInstance();
            p2=(Person)cons[1].newInstance(26);
            p3=(Person)cons[2].newInstance("bill");
            p4=(Person)cons[3].newInstance("mike",28);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        System.out.println("test3 输出：");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
    }

    /**
     * 返回类实现的接口
     */
    static void test4(){
        Class<?> p=null;
        try{
            p=Class.forName("com.reflect.demo.Person");
        }catch (Exception ex){
            ex.printStackTrace();
        }

        System.out.println("test4 输出：");

       Class<?>[] intes=p.getInterfaces();
        for(int i=0;i<intes.length;i++){
            System.out.println(intes[i].getName());
        }
    }

    /**
     * 返回类的父类
     */
    static void test5(){
        Class<?> p=null;
        try{
            p=Class.forName("com.reflect.demo.Person");
        }catch (Exception ex){
            ex.printStackTrace();
        }

        System.out.println("test5 输出：");

        Class<?> theSuperClass= p.getSuperclass();
        System.out.println(theSuperClass.getName());
    }

    /**
     * 获取构造函数修饰符
     */
    static void test6(){
        Class<?> p=null;
        try{
            p=Class.forName("com.reflect.demo.Person");
        }catch (Exception ex){
            ex.printStackTrace();
        }

        System.out.println("test6 输出：");
        Constructor<?>[] cons=p.getConstructors();
        for(int i=0;i<cons.length;i++){
            int mo=cons[i].getModifiers();
            System.out.println("mo="+mo+" Modifier.toString(mo)="+Modifier.toString(mo));
            System.out.println("cons["+i+"].getName()="+cons[i].getName());

            Class<?>[] params= cons[i].getParameterTypes();
            for (int j=0;j<params.length;j++){
                System.out.println("params["+j+"].getName()="+params[j].getName());
            }
            System.out.println("===========");
        }

    }

}
