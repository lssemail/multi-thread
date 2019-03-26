package com.liusir.thread.basic.book;

public class TestMainSub {

    public static void main(String[] args) {

        RunParentSubThread thread = new RunParentSubThread();
        thread.start();
    }
}
