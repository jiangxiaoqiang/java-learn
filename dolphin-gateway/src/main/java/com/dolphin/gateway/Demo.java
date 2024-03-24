package com.dolphin.gateway;

public class Demo {
    public static void main(String[] args) {
        sum1();
        sum2();
    }

    public static void sum1(){
        int x = 2;
        x = x++;
        System.out.println(x);
    }

    public static void sum2(){
        int x = 2;
        int y = x++;
        System.out.println(y);
    }
}
