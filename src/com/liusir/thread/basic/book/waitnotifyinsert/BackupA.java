package com.liusir.thread.basic.book.waitnotifyinsert;

public class BackupA  extends Thread{


    private DBTools dbTools;

    public BackupA(DBTools tools){

        this.dbTools = tools;
    }

    @Override
    public void run(){

        dbTools.backupA();
    }
}
