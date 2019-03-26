package com.liusir.thread.basic.book.synstaticmethod;

public class ThreadB extends Thread{

    @Override
    public void run() {

        Service.printB();
    }
}
