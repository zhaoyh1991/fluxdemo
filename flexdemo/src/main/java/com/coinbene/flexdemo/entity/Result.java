package com.coinbene.flexdemo.entity;

public class  Result<T>  {
    private String code;
    private String message;
    private T data;
    public static<T> Result fail(String  message){
        Result<T> objectResult = new Result<>();
        objectResult.setData(null);
        objectResult.setCode("0");
        objectResult.setMessage(message);
        return  objectResult;
    }
    public static<T> Result sucess(T  t){
        Result<T> objectResult = new Result<>();
        objectResult.setData(t);
        objectResult.setCode("100");
        objectResult.setMessage("");
        return  objectResult;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
