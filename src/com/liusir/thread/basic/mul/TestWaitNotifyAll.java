package com.liusir.thread.basic.mul;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by Administrator on 2019-1-4.
 */
public class TestWaitNotifyAll {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        int maxSize = 5;
        MyProducer myProducer = new MyProducer(queue, maxSize, "MyProducer");
        MyConsumer myConsumer = new MyConsumer(queue, maxSize, "MyConsumer");

        myProducer.start();
        myConsumer.start();
    }
}

class MyProducer extends Thread{

    private Queue<Integer> queue;
    private int maxSize;

    MyProducer(Queue<Integer> queue, int maxSize, String name){
        super(name);
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true){
            synchronized (queue){
                while (queue.size() == maxSize){
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Random random = new Random();
                int value = random.nextInt();
                queue.add(value);
                System.out.println("produce\t" + value);
                queue.notifyAll();
            }
        }
    }
}

class MyConsumer extends Thread{

    private Queue<Integer> queue;
    private int maxSize;

    MyConsumer(Queue<Integer> queue, int maxSize, String name){
        super(name);
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true){
            synchronized (queue){
                while (queue.isEmpty()){
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int value = queue.remove();
                System.out.println("consumer\t" + value);
                queue.notifyAll();
            }
        }
    }
}