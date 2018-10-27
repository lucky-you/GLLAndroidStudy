package com.gll.gllandroidstudy.model;

/**
 * author      : Z_B
 * date       : 2018/10/27
 * function  :
 */
public class TimeAndStatus {


    private String time;
    private String status;

    public TimeAndStatus(String time, String status) {
        this.time = time;
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
