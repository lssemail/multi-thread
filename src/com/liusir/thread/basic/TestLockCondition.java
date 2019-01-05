package com.liusir.thread.basic;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2019-1-5.
 */
public class TestLockCondition {

    public static final Lock lock = new ReentrantLock();
    public static final Condition produce = lock.newCondition();
    public static final Condition consumer = lock.newCondition();
    public static BlockingQueue<Integer> data = new LinkedBlockingQueue<>(10);

    public static void main(String[] args) {
        new Thread(new Producer(lock, produce, consumer, data)).start();
        new Thread(new Consumer(lock, produce, consumer, data)).start();
    }

}

class Producer implements Runnable{

    private Lock lock;
    private Condition produce;
    private Condition consumer;
    private BlockingQueue<Integer> data;

    public Producer(Lock lock, Condition produce, Condition consumer, BlockingQueue<Integer> data){

        this.lock = lock;
        this.produce = produce;
        this.consumer = consumer;
        this.data = data;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            while (true){
                if(data.size() == 10){
                    System.out.printf("%s-%s-done,waiting for consumer\n", Thread.currentThread(), "Producer");
                    produce.await();
                }
                int value = Double.valueOf(Math.random() * 10).intValue();
                System.out.printf("%s-%s-add-%d\n", Thread.currentThread(), "Producer", value);
                data.add(value);
                consumer.signalAll();
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){

        }finally {
            lock.unlock();
        }
    }
}

class Consumer implements Runnable{

    private Lock lock;
    private Condition produce;
    private Condition consumer;
    private BlockingQueue<Integer> data;

    public Consumer(Lock lock, Condition produce, Condition consumer, BlockingQueue<Integer> data){

        this.lock = lock;
        this.produce = produce;
        this.consumer = consumer;
        this.data = data;
    }

    @Override
    public void run() {
        lock.lock();

        try {
            while (true){
                if(data.size() == 0){
                    System.out.printf("%s-%s-is empty,waiting for producer\n", Thread.currentThread(), "Consumer");
                    consumer.await();
                }
                System.out.printf("%s-%s-poll-%d\n", Thread.currentThread(), "Consumer", data.poll());
                produce.signalAll();
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e){

        }finally {
            lock.unlock();
        }
    }
}
