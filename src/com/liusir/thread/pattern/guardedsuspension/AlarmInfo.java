package com.liusir.thread.pattern.guardedsuspension;

import com.liusir.thread.pattern.twophasetermination.AlarmType;

public class AlarmInfo {

    private String name;

    private AlarmType type;
    private String id;
    private String extraInfo;

    public AlarmInfo(){


    }

    public AlarmInfo(String id, AlarmType type){

        this.type = type;
        this.id = id;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AlarmType getType() {
        return type;
    }

    public void setType(AlarmType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AlarmInfo(String name){

        this.name = name;
    }

    @Override
    public String toString() {
        return "AlarmInfo{" +
                "name='" + name + '\'' +
                '}';
    }
}
