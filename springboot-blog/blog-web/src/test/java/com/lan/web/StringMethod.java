package com.lan.web;

/**
 * @program: myblog
 * @description:
 * @author: xujiannong
 * @create: 2020-07-30 10:24
 **/
public class StringMethod {

    public static void setValue(StringBuilder str) {
        str = new StringBuilder("sss");
    }

    public static void setValue2(StringBuilder str) {
        str.append("sss");
    }


    public static void main(String[] args) {

//        StringBuilder str = new StringBuilder();
//        setValue(str);
//
//        System.out.println(str.toString()); //输出空字符串
//
//
//        setValue2(str);
//        System.out.println(str.toString()); //输出sss
        String str = "小编";
        StringBuffer sb = new StringBuffer("我");
        cStr(str);
        cSb(sb);
        System.out.println(str);
        System.out.println(sb);

    }

    public static void cStr(String str) {
        str = "是帅哥";
    }

    public static void cSb(StringBuffer sb) {
        sb.append("是帅哥");
    }
}
