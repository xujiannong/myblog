package com.lan.web;

/**
 * @program: myblog
 * @description:
 * @author: xujiannong
 * @create: 2020-08-25 23:45
 **/
public class son extends father {

    static {
        System.out.println("2、调用子类的静态方法");
    }

    {
        System.out.println("5、调用子类的构造块方法");
    }

    son() {
        {
            System.out.println("6、调用子类的构造方法");
        }
    }

    public void nn() {
        System.out.println("7");
    }


    public static void main(String[] args) {
        son a = new son();
        a.nn();
    }


}

