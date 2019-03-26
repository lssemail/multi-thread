package com.liusir.thread.basic.book.synstaticmethod;

public class ThreadA extends Thread{

    @Override
    public void run() {

        Service.printA();
    }
}
