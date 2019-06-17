package com.demo.needmanage.entity;

public class Depatment {
    private Integer id;

    private String name;

    public Depatment(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Depatment() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}