package com.liusir.thread.basic.book.twothreadtransdata;

import java.util.ArrayList;
import java.util.List;

public class MyList {

    private List list = new ArrayList<>();

    public void add(){

        list.add("Thread");
    }

    public int size(){

        return list.size();
    }



}
