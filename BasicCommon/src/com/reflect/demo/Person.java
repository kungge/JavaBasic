package com.reflect.demo;

public class Person implements ILovePower {

    public Person(String theName,int theAge){
        name=theName;
        age=theAge;
    }

    public Person(String theName){
        name=theName;
    }

    public Person(int theAge){
        age=theAge;
    }

    public Person(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    int age;

    @Override
    public String toString() {
        return "我叫 "+name+" 今年"+age;
    }

    @Override
    public void showLove(String lover) {
        System.out.println(lover+" I Love You");
    }

    @Override
    public void groupUp() {
        System.out.println("Let us group up together");
    }
}
