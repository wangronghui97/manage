package com.demo.needmanage.dto;

import com.demo.needmanage.entity.Student;

import java.util.List;

public class StudentListDto {

    private List<StudentDto> entitys;

    private List<CascadeDto> depatments;

    private Integer total;


    public List<StudentDto> getEntitys() {
        return entitys;
    }

    public void setEntitys(List<StudentDto> entitys) {
        this.entitys = entitys;
    }

    public List<CascadeDto> getDepatments() {
        return depatments;
    }

    public void setDepatments(List<CascadeDto> depatments) {
        this.depatments = depatments;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
