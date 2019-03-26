package com.liusir.thread.basic.book;

public class TestMyThread {


    public static void main(String[] args) {


        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(10000);
            Thread.currentThread().interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end!");
    }
}
