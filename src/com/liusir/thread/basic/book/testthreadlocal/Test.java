package com.liusir.thread.basic.book.testthreadlocal;

public class Test {

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("main print:" + Tool.local.get());
                Thread.sleep(1000);
            }

            ThreadA a = new ThreadA();
            a.start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
