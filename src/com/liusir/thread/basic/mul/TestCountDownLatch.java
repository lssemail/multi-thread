package com.liusir.thread.basic.mul;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019-1-5.
 */
public class TestCountDownLatch {

    private static int NUM = 10;
    //https://www.cnblogs.com/lizhangyong/p/8906774.html

    public static void main(String[] args) {

        VideoConference conference = new VideoConference(NUM);
        new Thread(conference).start();
        for (int i = 0; i< NUM; i++){
            Participant participant = new Participant(conference, "Participant " + i);
            new Thread(participant).start();
        }


    }
}

class VideoConference implements Runnable{

    private final CountDownLatch latch;

    public VideoConference(int n){

        latch = new CountDownLatch(n);
    }

    public void arrive(String name){
        System.out.printf("%s has arrived.\n", name);
        latch.countDown();
        System.out.printf("waiting count for %s arrived.\n", String.valueOf(latch.getCount()));
    }

    @Override
    public void run() {

        synchronized (VideoConference.class){
            if(latch.getCount() != 0){
                System.out.printf("VideoConference: Initialization: %d participants.\n", latch.getCount());
            }
        }

        try {
            latch.await();
            System.out.printf("VideoConference: All the participants have come\n");
            System.out.printf("VideoConference: Let's start...\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Participant implements Runnable{

    private VideoConference conference;
    private String name;

    public Participant(VideoConference conference, String name){

        this.conference = conference;
        this.name = name;
    }

    @Override
    public void run() {

        long during = (long) Math.random() * 1000;

        try {
            TimeUnit.SECONDS.sleep(during);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        conference.arrive(name);
        System.out.println(this.name + " do some work");

    }
}
