package com.liusir.thread.basic.book.waitall;

public class Test {

    public static void main(String[] args) throws Exception{


        Object lock = new Object();
        Thread threada = new ThreadA(lock);
        Thread threadb = new ThreadB(lock);
        Thread threadc = new ThreadC(lock);

        threada.start();
        threadb.start();
        threadc.start();


        Thread.sleep(4000);

        NotifyThread notifyThread = new NotifyThread(lock);
        notifyThread.start();

    }
}
