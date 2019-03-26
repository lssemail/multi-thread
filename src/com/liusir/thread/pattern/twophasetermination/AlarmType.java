package com.liusir.thread.pattern.twophasetermination;

public enum AlarmType {

    FAULT("fault"),
    RESUME("resume");

    private final String name;

    private AlarmType(String name){

        this.name = name;
    }

    public String toString(){

        return name;
    }
}
