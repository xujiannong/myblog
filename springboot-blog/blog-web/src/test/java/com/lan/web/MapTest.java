package com.lan.web;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: myblog
 * @description:
 * @author: xujiannong
 * @create: 2020-08-13 10:14
 **/
public class MapTest {
    public static void main(String[] args) {
        Map mymap = new HashMap<String, String>();
        mymap.put("a", "a");
        mymap.put("a", "a");
        mymap.put("a", "b");
        System.out.println(mymap.get("a"));
        System.out.println(mymap.size());

        String a = "abcdef";
        a.chars();
        System.out.println(a.charAt(1));
    }
}
