package com.example.javaclass;

import com.example.javaclass.hello.Person;
import com.example.javaclass.hello.Student;

public class Tester {
    public static void main(String[] args) {
/*        Person person = new Person();
        person.hello();
        person.hello("Rubyyyyyer");
        person.setWeight(66);
        person.setHeight(1.7f);
        System.out.println(person.bmi(60, 1.7f));*/

        Student studentA = new Student("001","Rubyyyyyer",20,50);
        Student studentB = new Student("002","Selinnnnnn",60,80);
        Student studentC = new Student("003","Seannnnnnn",70,70);
//        student.setId("001");
        studentA.print();
        studentB.print();
        studentC.print();




    }
}


