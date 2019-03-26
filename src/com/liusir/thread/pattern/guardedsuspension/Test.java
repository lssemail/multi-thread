package com.liusir.thread.pattern.guardedsuspension;

import java.util.concurrent.TimeUnit;

public class Test {


    public static void main(String[] args) throws Exception{

        AlarmAgent alarmAgent = new AlarmAgent();
        alarmAgent.init();
        AlarmInfo info = new AlarmInfo("Hello world");
        DisconectedThread disconectedThread = new DisconectedThread(alarmAgent);
        disconectedThread.start();

        while (true){
            alarmAgent.sendAlarm(info);
            TimeUnit.SECONDS.sleep(4);
        }


    }
}
