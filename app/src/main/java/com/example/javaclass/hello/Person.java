package com.example.javaclass.hello;

public class Person {
    float weight;
    float height;

    public float bmi(float weight, float height) {
        return weight / (height * height);
    }

    public void hello() {
        System.out.println("hello java!");
    }

    public void hello(String name) {
        System.out.println("hello," + name);
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}





