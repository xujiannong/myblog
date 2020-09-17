package com.lan.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @program: myblog
 * @description:
 * @author: xujiannong
 * @create: 2020-08-13 10:14
 **/
public class MapTest {

    String name;

    public MapTest(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
//        Map mymap = new HashMap<String, String>();
//        mymap.put("a", "a");
//        mymap.put("a", "a");
//        mymap.put("a", "b");
//        System.out.println(mymap.get("a"));
//        System.out.println(mymap.size());
//
//        String a = "abcdef";
//        a.chars();
//        System.out.println(a.charAt(1));

        Map<MapTest, String> map = new HashMap<>(4);
        map.put(new MapTest("hello"), "hello");
        String hello = map.get(new MapTest("hello"));
        System.out.println(hello);

        Map<String, MapTest> map2 = new HashMap<>(4);
        map2.put("hello", new MapTest("hello") );
        String hello2 = map2.get("hello").toString();
        System.out.println(hello2.hashCode());
        System.out.println(new MapTest("hello").hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MapTest test1 = (MapTest) o;
        return Objects.equals(name, test1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
