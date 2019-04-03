package com.liusir.thread.basic.book.produceconsume;

public class ConsumeThread extends Thread{

    private Consume consume;

    public ConsumeThread(Consume c){

        super();
        this.consume = c;
    }

    @Override
    public void run(){

        while (true){
            consume.getValue();
        }
    }
}
