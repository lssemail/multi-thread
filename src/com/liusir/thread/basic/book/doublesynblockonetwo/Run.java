package com.liusir.thread.basic.book.doublesynblockonetwo;

public class Run {

    public static void main(String[] args) {

        ObjectService service = new ObjectService();
        ThreadA threadA = new ThreadA(service);
        ThreadB threadB = new ThreadB(service);

        threadA.setName("A");
        threadB.setName("B");


        threadB.start();
        threadA.start();
    }
}
