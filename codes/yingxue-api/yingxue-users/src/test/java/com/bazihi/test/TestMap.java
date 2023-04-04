package com.bazihi.test;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<String, String> maps = new HashMap<>();

        maps.put("aa", "xiaochen");
        maps.put("bb", "xiaochen");
        maps.put("bb", "xiaochen");
        maps.put("bb", "xiaochen");
        maps.put("bb", "xiaochen");
        maps.put("bb", "xiaochen");
        maps.put("bb", "xiaochen");


        System.out.println(maps.get("aa"));

    }
}
