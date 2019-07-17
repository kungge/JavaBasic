package com.annotation.demo;

@MyAnnotation(value = "theValue",lover = "yl",wifi="lingzi",arrayAttr={1,3,4},loanStatus=LoanStatusEnum.Loan,ma=@MetaAnnotation("nice"))
public class test {
    @MyAnnotation("you are good")
    public static void main(String[] args) {

        if(test.class.isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation a=(MyAnnotation)test.class.getAnnotation(MyAnnotation.class);
            System.out.println(" lover="+a.lover());
            System.out.println(" wifi="+a.wifi());
            System.out.println(" arrayAttr="+a.arrayAttr());
            System.out.println(" loanStatus="+a.loanStatus());
            System.out.println(" ma="+a.ma());

            System.out.println("MetaAnnotation:");
            MetaAnnotation ma=a.ma();
            System.out.println(ma.value());
        }
    }
}
