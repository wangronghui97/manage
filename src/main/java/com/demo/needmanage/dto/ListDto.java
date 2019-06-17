package com.demo.needmanage.dto;

import com.demo.needmanage.entity.Notice;

import java.util.List;

public class ListDto<T>{

    private List<T> entitys;

    public List<T> getEntitys() {
        return entitys;
    }

    public void setEntitys(List<T> entitys) {
        this.entitys = entitys;
    }

    private Integer total;



    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
