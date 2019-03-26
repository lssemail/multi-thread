package com.liusir.thread.basic.book;

public class RunParentSubThread extends Thread{


    @Override
    public void run() {
        super.run();

        SubThread subThread = new SubThread();
        subThread.operationSub();
    }
}
