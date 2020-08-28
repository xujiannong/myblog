package com.lan.web;

/**
 * @program: myblog
 * @description:
 * @author: xujiannong
 * @create: 2020-08-26 10:02
 **/
public class father {

    public father() {
        System.out.println("4、调用父类的构造方法");
    }

    static {
        System.out.println("1、调用父类的静态方法");
    }

    {
        System.out.println("3、调用父类的构造块方法");
    }

    public static void got() {
        System.out.println("调用T类的方法，静态方法");
    }

    public static void main(String[] args) {
        new father();
    }
}
