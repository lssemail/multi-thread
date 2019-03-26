package com.liusir.thread.pattern.twophasetermination;

import com.liusir.thread.pattern.guardedsuspension.AlarmInfo;
import com.liusir.thread.pattern.util.Debug;

public class AlarmMgr {

    private static final AlarmMgr INSTANCE = new AlarmMgr();

    private volatile boolean shutdownRequested = Boolean.FALSE;

    private final AlarmSendingThread alarmSendingThread;

    private AlarmMgr(){

        this.alarmSendingThread = new AlarmSendingThread();
    }

    public static AlarmMgr getInstance(){

        return INSTANCE;
    }

    public int sendAlarm(AlarmType type, String id, String extraInfo){

        Debug.info("Trigger alarm " + type + "," + id + "," + extraInfo);
        int duplicateSubmissionCount = 0;
        try {
            AlarmInfo alarmInfo = new AlarmInfo(id, type);
            alarmInfo.setExtraInfo(extraInfo);

//            duplicateSubmissionCount = alarmSendingThread.sendAlarm(alarmInfo);
        }catch (Exception e){

        }

        return duplicateSubmissionCount;

    }

    public void init(){

        //alarmSendingThread.start();
    }

    public synchronized void shutdown(){

        if(shutdownRequested){
            throw new IllegalStateException("shutdown already requested!");
        }

        //alarmSendingThread.terminate();
        shutdownRequested = true;
    }

}
