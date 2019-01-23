package com.liusir.thread.basic.mul;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019-1-5.
 */
public class TestCyclicBarrier {

    public static void main(String[] args) {

        int num = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(num,()->{
            System.out.println("start video...");
        });
        for (int i = 0; i< num; i++){
            new Thread(new MyParticipant(cyclicBarrier, "Participant " + i)).start();
        }
        System.out.println("end");
    }
}

class MyParticipant implements Runnable{


    private CyclicBarrier barrier;
    private String name;

    public MyParticipant(CyclicBarrier barrier, String name){

        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run() {

        long during = (long) Math.random() * 100;
        try {
            TimeUnit.SECONDS.sleep(during);
            System.out.printf("%s is coming\n", name);
            barrier.await();
            System.out.printf("%s is watching video\n", name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (BrokenBarrierException e){

        }


    }
}
