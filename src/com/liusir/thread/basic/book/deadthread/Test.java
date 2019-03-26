package com.liusir.thread.basic.book.deadthread;

public class Test {

    public static void main(String[] args) throws Exception{


        DeadThread deadThread = new DeadThread();
        deadThread.setUsername("a");
        Thread thread1 = new Thread(deadThread);
        thread1.start();
        Thread.sleep(100);

        deadThread.setUsername("b");
        Thread thread2 = new Thread(deadThread);
        thread2.start();

    }
}
