package com.lan.web;

/**
 * @program: myblog
 * @description:
 * @author: xujiannong
 * @create: 2020-09-07 17:54
 **/
public class DayTest {

    public static void main(String[] args) {
        //第一组
//1
        long time1 = System.currentTimeMillis();
        String str1 = "hello";
        str1 += "，world";
        long time2 = System.currentTimeMillis();
        System.out.println("程序运行时间： "+(time2-time1)+"ms");

//2
        StringBuilder sb1 = new StringBuilder("hello");
        sb1.append("，world");
        long time3 = System.currentTimeMillis();
        System.out.println("程序运行时间： "+(time3-time2)+"ms");

//第二组
//1
        String str2 = "hello";
        for (int i = 0; i < 3; i++) {
            str2 += "，world";
        }
        long time4 = System.currentTimeMillis();
        System.out.println("程序运行时间： "+(time4-time3)+"ms");

//2
        StringBuilder sb2 = new StringBuilder("hello");
        for (int i = 0; i < 3; i++) {
            sb2.append("，world");
        }
        long time5 = System.currentTimeMillis();
        System.out.println("程序运行时间： "+(time5-time4)+"ms");

    }
}
