package com.liusir.thread.basic.book.produceconsume;

public class ProduceThread extends Thread{

    private Produce produce;

    public ProduceThread(Produce p){

        super();
        this.produce = p;
    }

    @Override
    public void run(){

        while (true){
            produce.setValue();
        }
    }
}
