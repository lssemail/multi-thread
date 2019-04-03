package com.liusir.thread.basic.book.produceconsume;

public class Test {


    public static void main(String[] args) {

        String lock = new String("");
        Produce produce = new Produce(lock);
        Consume consume = new Consume(lock);

        ProduceThread produceThread = new ProduceThread(produce);
        ConsumeThread consumeThread = new ConsumeThread(consume);

        produceThread.start();
        consumeThread.start();

    }
}
