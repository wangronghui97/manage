package com.demo.needmanage.entity;

public class Type {
    private Integer id;

    private String name;

    private String conditional;

    public Type(Integer id, String name, String conditional) {
        this.id = id;
        this.name = name;
        this.conditional = conditional;
    }

    public Type() {
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

    public String getConditional() {
        return conditional;
    }

    public void setConditional(String conditional) {
        this.conditional = conditional == null ? null : conditional.trim();
    }
}