package com.liusir.thread.basic.book.deadthread;

public class DeadThread implements Runnable{



    private String username;

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void setUsername(String username){

        this.username = username;
    }

    @Override
    public void run() {

        if("a".equals(username)){
            synchronized (lock1){
                try {

                    System.out.println("username=" + username);
                    Thread.sleep(3000);
                }catch (Exception e){

                }

                synchronized (lock2){
                    System.out.println("lock1 to lock2");
                }
            }


        }

        if("b".equals(username)){
            synchronized (lock2){
                try {

                    System.out.println("username=" + username);
                    Thread.sleep(3000);
                }catch (Exception e){

                }

                synchronized (lock1){
                    System.out.println("lock2 to lock1");
                }
            }


        }

    }
}
