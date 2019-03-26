package com.liusir.thread.pattern.guardedsuspension;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionVarBlocker implements Blocker{


    private final Lock lock;

    private final Condition condition;


    public ConditionVarBlocker(Lock lock){

        this.lock = lock;
        this.condition = lock.newCondition();
    }

    public ConditionVarBlocker(){

        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }



    @Override
    public <V> V callWithGuard(GuardedAction<V> guardedAction) throws Exception {

        lock.lockInterruptibly();
        V result;
        try {

            final Predicate guard = guardedAction.guard;
            while (!guard.evauluate()){

                System.out.println("await");
                condition.await();
            }

            result = guardedAction.call();
            return result;

        }catch (Exception e){

            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return null;
    }

    @Override
    public void signalAfter(Callable<Boolean> stateOperation) throws Exception {

        lock.lockInterruptibly();
        try {

            if(stateOperation.call()){
                condition.signal();
            }
        }catch (Exception e){

        }finally {
            lock.unlock();
        }

    }

    @Override
    public void signal() throws InterruptedException {

        lock.lockInterruptibly();
        try {

            condition.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    @Override
    public void broadCastAfter(Callable<Boolean> stateOperation) throws Exception {

        lock.lockInterruptibly();
        try {

            if(stateOperation.call()){
                condition.signalAll();
            }
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
}
