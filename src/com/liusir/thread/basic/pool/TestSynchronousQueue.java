package com.liusir.thread.basic.pool;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class TestSynchronousQueue {

    public static void main(String[] args) {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        new Thread(()-> {
            try {
                while (true){
                    Integer value = Integer.valueOf(Double.valueOf(Math.random() * 10).intValue());
                    System.out.println("put value:" + value);
                    TimeUnit.SECONDS.sleep(2);
                    queue.put(value);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                while (true){
                    Integer value = queue.take();
                    TimeUnit.SECONDS.sleep(4);
                    System.out.println("take value" + value);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

