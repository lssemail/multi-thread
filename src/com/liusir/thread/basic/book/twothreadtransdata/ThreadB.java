package com.liusir.thread.basic.book.twothreadtransdata;

public class ThreadB extends Thread{


    private MyList myList;

    public ThreadB(MyList myList){

        super();
        this.myList = myList;
    }

    @Override
    public void run() {
        try {

            while (Boolean.TRUE){
                if(myList.size() == 5){
                    System.out.println("size = 5, exit");
                    throw new InterruptedException();

                }
            }
        }catch (Exception e){

            e.printStackTrace();
        }
    }
}
