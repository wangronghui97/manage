package com.demo.needmanage.dto;

public class LoginResponse<T>{

    private T info;

    private String type;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "info=" + info +
                ", type='" + type + '\'' +
                '}';
    }
}
