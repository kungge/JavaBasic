package com.annotation.demo;

public class TestCenter {

    @SuppressWarnings("")
    public static void main(String[] args) {
        System.out.println("TestCenter main()");

        System.runFinalizersOnExit(true);// runFinalizersOnExit 这个方法使用了 @Deprecated 表示 "废弃的，过时的"

        showLove();// 自己标注了 @Deprecated

        test1();
        test2();
        test3();
        test4();
    }

    @Deprecated
    public static void showLove(){
        System.out.println("I Love You");
    }

    @Override  // 重写标注，表示覆盖 JDK 内部基类 Object 的 toString() 方法
    public String toString() {
        return super.toString();
    }


/*    public void referData(){
        // http://www.kungge.com/gooditblog/3689.html
    }*/

    static void test1(){
        System.out.println("test1：");
        if(Person.class.isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation a=(MyAnnotation)Person.class.getAnnotation(MyAnnotation.class);
            System.out.println(a);
        }
    }

    static void test2(){
        System.out.println("test2：");
        if(Person.class.isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation a=(MyAnnotation)Person.class.getAnnotation(MyAnnotation.class);
            System.out.println(a.lover());
        }
    }

    static void test3(){
        System.out.println("test3：");
        if(Person.class.isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation a=(MyAnnotation)Person.class.getAnnotation(MyAnnotation.class);
            System.out.println(a.lover()+" "+a.wifi());
        }
    }

    static void test4(){
        System.out.println("test4：");
        if(Person.class.isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation a=(MyAnnotation)Person.class.getAnnotation(MyAnnotation.class);
            System.out.println(a.lover()+" "+a.wifi()+" "+a.arrayAttr());
        }
    }
}
