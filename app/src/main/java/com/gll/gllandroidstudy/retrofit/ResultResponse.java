package com.gll.gllandroidstudy.retrofit;

public class ResultResponse<T> {

    public int code;
    public String msg;
    public long time;
    public T list;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public T getList() {
        return list;
    }

    public void setList(T list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ResultResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", time=" + time +
                ", list=" + list +
                '}';
    }
}
