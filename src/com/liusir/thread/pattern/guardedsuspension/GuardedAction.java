package com.liusir.thread.pattern.guardedsuspension;

import java.util.concurrent.Callable;

public abstract class GuardedAction<V> implements Callable<V> {

    protected final Predicate guard;

    public GuardedAction(Predicate predicate){

        this.guard = predicate;
    }
}
