package com.example.javaclass;

import com.example.javaclass.hello.Person;

public class Tester {
    public static void main(String[] args) {
        Person person = new Person();


        person.hello();

        person.hello("Rubyyyyyer");

        person.setWeight(66);
        person.setHeight(1.7f);
        person.bmi(60, 1.7f);

    }
}


