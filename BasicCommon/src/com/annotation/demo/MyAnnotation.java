package com.annotation.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface MyAnnotation {
    // String lover();// 注意
    String value();
    String lover() default "ling";
    String wifi() default "yl";
    int[] arrayAttr() default {5,2,0};
    LoanStatusEnum loanStatus() default LoanStatusEnum.Apply;
    MetaAnnotation ma() default @MetaAnnotation("good");
}
