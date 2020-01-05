package com.example.demo;

public class Test {

    int anInt =  Integer.parseInt("x");

    public static void main(String[] args) {
        try {
            Test test = new Test();
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("eee");
        }
        System.out.println("hhh");
    }


}
