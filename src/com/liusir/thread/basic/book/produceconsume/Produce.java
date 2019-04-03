package com.liusir.thread.basic.book.produceconsume;

public class Produce {

    private String lock;

    public Produce(String lock){

        super();
        this.lock = lock;

    }


    public void setValue(){

        try {
            synchronized (lock){
                if(!ValueObject.value.equals("")){
                    lock.wait();
                }

                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println("Set value=" + value);

                ValueObject.value = value;
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
