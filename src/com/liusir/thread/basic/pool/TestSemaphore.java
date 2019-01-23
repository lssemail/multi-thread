package com.liusir.thread.basic.pool;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TestSemaphore {

    public static void main(String[] args) throws Exception{
        Semaphore semaphore = new Semaphore(1);

        new Thread(()->{
            try {
                while (true){
                    semaphore.acquire();
                    System.out.println(Thread.currentThread());
                    TimeUnit.SECONDS.sleep(10);
                    semaphore.release();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                while (true){
                    semaphore.acquire();
                    System.out.println(Thread.currentThread());
                    TimeUnit.SECONDS.sleep(2);
                    semaphore.release();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}

