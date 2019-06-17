package com.demo.needmanage.dto;

import com.demo.needmanage.entity.Depatment;
import com.demo.needmanage.entity.Special;

import java.util.List;

public class SpecialListDto {

    private List<SpecialDto> entitys;

    private List<Depatment> depatments;

    private Integer total;


    public List<SpecialDto> getEntitys() {
        return entitys;
    }

    public void setEntitys(List<SpecialDto> entitys) {
        this.entitys = entitys;
    }

    public List<Depatment> getDepatments() {
        return depatments;
    }

    public void setDepatments(List<Depatment> depatments) {
        this.depatments = depatments;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
