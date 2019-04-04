package com.liusir.thread.basic.book.testthreadlocal;

public class ThreadA extends Thread{

    @Override
    public void run() {

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("threadA print:" + Tool.local.get());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
