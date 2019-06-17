package com.demo.needmanage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Instructor {
    private Integer id;

    private String phone;

    private String qq;

    private Integer sex;

    private String name;

    @JsonIgnore
    private String password;

    private String number;

    public Instructor(Integer id, String phone, String qq, Integer sex, String name, String password, String number) {
        this.id = id;
        this.phone = phone;
        this.qq = qq;
        this.sex = sex;
        this.name = name;
        this.password = password;
        this.number = number;
    }

    public Instructor() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }
}