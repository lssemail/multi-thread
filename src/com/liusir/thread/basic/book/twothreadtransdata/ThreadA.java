package com.liusir.thread.basic.book.twothreadtransdata;

public class ThreadA extends Thread{


    private MyList myList;

    public ThreadA(MyList myList){

        super();
        this.myList = myList;
    }

    @Override
    public void run() {
        super.run();
        try {

            for (int i = 0; i < 10; i++) {
                myList.add();
                System.out.println("add elements size:" + myList.size());
                Thread.sleep(1000);
            }
        }catch (Exception e){

        }
    }
}
