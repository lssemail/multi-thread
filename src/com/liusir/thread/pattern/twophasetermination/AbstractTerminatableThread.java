package com.liusir.thread.pattern.twophasetermination;

public abstract class AbstractTerminatableThread extends Thread implements Terminatable{

    public final TerminationToken terminationToken;

    public AbstractTerminatableThread(){

        this(new TerminationToken());
    }

    public AbstractTerminatableThread(TerminationToken token){

        super();
        this.terminationToken = token;
        terminationToken.register(this);
    }

    protected abstract void doRun() throws Exception;

    protected void doCleanup(Exception cause){

    }

    protected void doTerminiate(){

    }

    @Override
    public void run() {

    }

    @Override
    public void interrupt(){

    }

//    @Override
//    public void terninate(){
//
//    }
}
