package com.liusir.thread.basic.book.produceconsume;

public class Consume {

    private String lock;

    public Consume(String lock){

        super();
        this.lock = lock;

    }


    public void getValue(){

        try {
            synchronized (lock){
                if(ValueObject.value.equals("")){
                    lock.wait();
                }

                System.out.println("Get value=" + ValueObject.value);

                ValueObject.value = "";
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
