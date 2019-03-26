package com.liusir.thread.pattern.guardedsuspension;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.logging.Logger;


/**
 * 负责链接告警服务器，并发送报告信息至告警服务器
 */
public class AlarmAgent {

    private volatile boolean connectedToServer = false;

    private final Predicate agentConnected = new Predicate() {
        @Override
        public boolean evauluate() {

            return connectedToServer;
        }
    };

    private final Blocker blocker = new ConditionVarBlocker();

    private final Timer heartBeatTimer = new Timer(true);


    public void sendAlarm(final AlarmInfo alarm){

        GuardedAction<Void> guardedAction = new GuardedAction<Void>(agentConnected) {

            @Override
            public Void call() throws Exception {
                doSendAlarm(alarm);
                return null;
            }
        };

        try {
            blocker.callWithGuard(guardedAction);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void doSendAlarm(AlarmInfo alarm){

        System.out.println("sending alarm:" + alarm);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void init(){

        Thread connectingThread = new Thread(new ConnectingTask());
        connectingThread.start();
        heartBeatTimer.schedule(new HeartBeatTask(), 6000, 2000);


    }

    public void disconnect(){

        System.out.println("disconnected from alarm server.");
        connectedToServer = false;

    }

    protected void onConnected(){

        try {
            blocker.signalAfter(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    connectedToServer = true;
                    System.out.println("connected to server");
                    return Boolean.TRUE;
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void onDisconnected(){

        connectedToServer = false;
    }

    private class ConnectingTask implements Runnable{

        @Override
        public void run() {

            try {

                Thread.sleep(500);
            }catch (Exception e){

            }
            System.out.println("try connected to server");

            onConnected();
        }
    }

    private class HeartBeatTask extends TimerTask{

        @Override
        public void run() {

            System.out.println("HeartBeatTask doing...");
            if(!testConnected()){
                onDisconnected();
                reconnect();

            }
        }

        private boolean testConnected(){

            return connectedToServer;
        }

        private void reconnect(){

            ConnectingTask connectingTask = new ConnectingTask();
            connectingTask.run();
        }
    }



}
