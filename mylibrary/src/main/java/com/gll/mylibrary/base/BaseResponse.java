package com.gll.mylibrary.base;

/**
 * Created by: Z_B on 2018/8/23.
 * Function:
 */
public class BaseResponse<T> {
    public static final int SUCCESS = 1;
    public static final int ERROR = 1000;
    private int code;
    private String msg;
    private String time;
    private T data;

    public boolean isSuccess() {
        return (code == SUCCESS);
    }

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", time='" + time + '\'' +
                ", data=" + data +
                '}';
    }
}
