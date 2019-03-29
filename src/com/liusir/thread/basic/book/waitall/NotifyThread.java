package com.liusir.thread.basic.book.waitall;

import java.time.LocalTime;

public class NotifyThread extends Thread{

    private Object lock;

    public NotifyThread(Object lock){

        this.lock = lock;
    }

    @Override
    public void run(){

        try {
            synchronized (lock){
                System.out.println("begin notify, thread name=" + Thread.currentThread().getName() + ",time=" + LocalTime.now());

                lock.notify();
                Thread.sleep(2000);
                System.out.println("notify waiting, thread name=" + Thread.currentThread().getName() + ",time=" + LocalTime.now());

                lock.notify();
                Thread.sleep(2000);

                System.out.println("notify waiting, thread name=" + Thread.currentThread().getName() + ",time=" + LocalTime.now());

                lock.notify();
                Thread.sleep(2000);
                System.out.println("notify waiting, thread name=" + Thread.currentThread().getName() + ",time=" + LocalTime.now());


                System.out.println("end notify, thread name=" + Thread.currentThread().getName() + ",time=" + LocalTime.now());


            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
