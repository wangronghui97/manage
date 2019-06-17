package com.demo.needmanage.dto;

import com.demo.needmanage.comment.MessageCode;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponeCode<T> {

    private Integer status;

    private String msg;

    private T data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static ResponeCode newResponeCode(MessageCode messageCode){

        ResponeCode responeCode = new ResponeCode();

        responeCode.status=messageCode.getCode();
        responeCode.msg=messageCode.getMessage();
        return responeCode;

    }
}
