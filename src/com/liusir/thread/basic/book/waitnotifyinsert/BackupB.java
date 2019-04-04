package com.liusir.thread.basic.book.waitnotifyinsert;

public class BackupB extends Thread{


    private DBTools dbTools;

    public BackupB(DBTools tools){

        this.dbTools = tools;
    }

    @Override
    public void run(){

        dbTools.backupB();
    }
}
