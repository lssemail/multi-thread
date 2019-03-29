package com.liusir.thread.basic.book.waitall;

import java.time.LocalTime;

public class Service {

    public void testMethod(Object lock){

        try {
            synchronized (lock){
                System.out.println("begin wait, thread name=" + Thread.currentThread().getName() + ",time=" + LocalTime.now());
                lock.wait();
                System.out.println("end wait, thread name=" + Thread.currentThread().getName() + ",time=" + LocalTime.now());

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
