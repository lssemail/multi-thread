package com.liusir.thread.basic.book;

public class ParentThread{

    public int i = 10;


    synchronized public void operationMain() {

        try {
            i--;
            System.out.println("parent print i=" + i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }


}
