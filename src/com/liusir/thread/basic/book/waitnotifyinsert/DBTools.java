package com.liusir.thread.basic.book.waitnotifyinsert;

public class DBTools {

    private volatile boolean prevA = Boolean.FALSE;

    synchronized public void backupA(){

        try {
            while (prevA){

                this.wait();
            }

            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\tAAAAA");
            }

            prevA = Boolean.TRUE;
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void backupB(){

        try {
            while (!prevA){

                this.wait();
            }

            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\tBBBBB");
            }

            prevA = Boolean.FALSE;
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
