package com.liusir.thread.basic.pool;

import java.util.concurrent.*;

public class TestExecutorService {

    public static void main(String[] args) throws Exception{

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future future = executorService.submit(()->{
            try {
                TimeUnit.SECONDS.sleep(19);
                System.out.println("haha");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(future.isDone());
        System.out.println(future.get());



    }

}

