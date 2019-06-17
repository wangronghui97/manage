package com.demo.needmanage.entity;

public class Class {
    private Integer id;

    private String name;

    private Integer specialId;

    private Integer depatmentId;

    private Integer instructorId;

    private String grade;

    public Class(Integer id, String name, Integer specialId, Integer depatmentId, Integer instructorId, String grade) {
        this.id = id;
        this.name = name;
        this.specialId = specialId;
        this.depatmentId = depatmentId;
        this.instructorId = instructorId;
        this.grade = grade;
    }

    public Class() {
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

    public Integer getSpecialId() {
        return specialId;
    }

    public void setSpecialId(Integer specialId) {
        this.specialId = specialId;
    }

    public Integer getDepatmentId() {
        return depatmentId;
    }

    public void setDepatmentId(Integer depatmentId) {
        this.depatmentId = depatmentId;
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }
}