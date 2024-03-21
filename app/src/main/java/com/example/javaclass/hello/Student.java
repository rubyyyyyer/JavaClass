package com.example.javaclass.hello;

public class Student {
    public static int pass = 60;
    String id;
    String name;

    int english;
    int math;


    public Student(String id, String name, int english, int math) {
        this.id = id;
        this.name = name;

        this.english = english;
        this.math = math;
    }
    public void print(){
        System.out.print("Student ID:"+id+"\t Name:"+name+"\t English:"+english+"\t Math:"+math+"\t average:"+getAverage());
        if (getAverage() < pass){
            System.out.println("*");
        }else {
            System.out.println();
        }
    }
     private int getAverage(){
        return (math+english)/2;

    }
}
