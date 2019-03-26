package com.liusir.thread.basic.book.synstaticmethod;



public class Service {


    synchronized public static void printA(){

        try {
            System.out.println("线程名为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入printA");
            Thread.sleep(3000);
            System.out.println("线程名为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开printA");
        }catch (Exception e){

        }

    }

    synchronized public static void printB(){

        System.out.println("线程名为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入printB");
        System.out.println("线程名为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开printB");

    }
}
