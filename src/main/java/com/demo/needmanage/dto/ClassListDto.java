package com.demo.needmanage.dto;

import com.demo.needmanage.entity.Class;
import com.demo.needmanage.entity.Instructor;

import java.util.List;

public class ClassListDto {

    private List<ClassDto> entitys;

    private List<CascadeDto> depatments;

    private List<Instructor> instructors;

    private Integer total;

    public Integer getTotal() {
        return total;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<ClassDto> getEntitys() {
        return entitys;
    }

    public void setEntitys(List<ClassDto> entitys) {
        this.entitys = entitys;
    }

    public List<CascadeDto> getDepatments() {
        return depatments;
    }

    public void setDepatments(List<CascadeDto> depatments) {
        this.depatments = depatments;
    }
}
