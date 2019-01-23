package com.liusir.thread.basic.collection;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.List;

public class TestArrayQueue {

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(8);

        List<String> list = new ArrayList<>();
        list.add("g");
        list.add("o");
        list.add("o");
        list.add("d");
        List<String> other = new ArrayList<>();
        other.add("g");

        list.retainAll(other);
        System.out.println(list);

    }
}

