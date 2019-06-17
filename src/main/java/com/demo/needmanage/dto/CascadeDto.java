package com.demo.needmanage.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CascadeDto {

    private Integer value;

    private String label;

    private List<CascadeDto> children;

    public List<CascadeDto> getChildren() {
        return children;
    }

    public void setChildren(List<CascadeDto> children) {
        this.children = children;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
