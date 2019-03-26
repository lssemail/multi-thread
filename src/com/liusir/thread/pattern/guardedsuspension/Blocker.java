package com.liusir.thread.pattern.guardedsuspension;

import java.util.concurrent.Callable;

public interface Blocker {

    <V> V callWithGuard(GuardedAction<V> guardedAction) throws Exception;

    void signalAfter(Callable<Boolean> stateOperation) throws Exception;

    void signal() throws InterruptedException;

    void broadCastAfter(Callable<Boolean> stateOperation) throws Exception;

}
