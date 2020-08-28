package com.lan.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @program: myblog
 * @description:
 * @author: xujiannong
 * @create: 2020-08-18 14:43
 **/
public class ListTest {
    public static void main(String[] args) {
        List list1 = new ArrayList<>();
        List list2 = new ArrayList<>();
        list1.add("w");
        list1.add("g");
        list1.add("v");
        list1.add("r");
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add("d");
        list2.add("e");
//        list1.addAll(list2);
//        for(int i=0;i<list1.size();i++){
//            System.out.println(list1.get(i));
//        }
        list1.retainAll(list2);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }

        String name = "沉默王二";
        // \u000dname="沉默王三";
        System.out.println(name);

        Vector vector = new Vector(4);
        vector.add("a");
        vector.add("b");
        System.out.println(vector.get(1).toString());
    }
}
