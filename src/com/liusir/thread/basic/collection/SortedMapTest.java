package com.liusir.thread.basic.collection;

import java.util.*;

public class SortedMapTest {

    public static void main(String[] args) {
        SortedMap<String, String> map = new TreeMap<>();

        map.put("1", "1");
        map.put("3", "3");
        map.put("2", "2");

        System.out.println(map.firstKey());
        System.out.println(map.lastKey());



    }
}

