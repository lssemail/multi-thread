package com.liusir.thread.basic.mul;

/**
 * Created by Administrator on 2019-1-4.
 */
public class TestJoin {

    public static void main(String[] args) throws InterruptedException{

        Thread myThread = new Thread(() ->{
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hahaha1");
        });
        for(int i = 0; i < 10; i++){

            Thread.sleep(1000);
            if(i == 5){
                myThread.start();
                myThread.join(10000);
                System.out.println("hahaha2");
            }
            System.out.println(Thread.currentThread().getName() + ":" + i +"\t" +  System.currentTimeMillis());
        }
    }
}
