package com.liusir.thread.pattern.guardedsuspension;

import java.util.concurrent.TimeUnit;

public class DisconectedThread extends Thread{

    private AlarmAgent alarmAgent;

    public DisconectedThread(AlarmAgent alarmAgent){

        this.alarmAgent = alarmAgent;
    }

    @Override
    public void run() {

        while (true){
            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            alarmAgent.disconnect();
        }

    }
}
