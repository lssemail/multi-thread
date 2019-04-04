package com.liusir.thread.basic.book.testjoin;

public class Test {

    public static void main(String[] args) throws Exception{

        LongTimeThread thread = new LongTimeThread();;
        thread.start();
        thread.join();
        System.out.println("end main");
    }

}

class LongTimeThread extends Thread{

    public void run(){

        try {
            System.out.println("begin sleep");
            Thread.sleep(10000);
            System.out.println("end sleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
