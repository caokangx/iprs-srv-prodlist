package edu.nju.iip.iprs.message;

public class ApiMessage<T> {

    private T data;

    private String msg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ApiMessage() {
    }

    public ApiMessage(T data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    public ApiMessage(T data) {
        this.data = data;
    }
}
