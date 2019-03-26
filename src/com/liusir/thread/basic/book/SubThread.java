package com.liusir.thread.basic.book;

public class SubThread extends ParentThread{


    synchronized public void operationSub() {


        try {
            while (i > 0){
                i--;
                System.out.println("sub print i=" + i);
                Thread.sleep(100);
                this.operationMain();
            }

        }catch (Exception e){

        }

    }
}
