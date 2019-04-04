package com.liusir.thread.basic.book.testthreadlocal;

import java.time.LocalTime;

public class InheritableThreadLocalExt extends InheritableThreadLocal{

    @Override
    protected Object initialValue() {

        return LocalTime.now();
    }

    @Override
    protected Object childValue(Object parentValue) {

        return parentValue + "in sub thread";
    }
}
