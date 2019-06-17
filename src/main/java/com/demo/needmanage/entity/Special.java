package com.demo.needmanage.entity;

public class Special {
    private Integer id;

    private Integer depatmentId;

    private String name;

    public Special(Integer id, Integer depatmentId, String name) {
        this.id = id;
        this.depatmentId = depatmentId;
        this.name = name;
    }

    public Special() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepatmentId() {
        return depatmentId;
    }

    public void setDepatmentId(Integer depatmentId) {
        this.depatmentId = depatmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}