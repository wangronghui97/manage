package com.demo.needmanage.dto;

public class ClassDto {

    private Integer id;

    private String name;

    private Integer specialId;

    private String specialName;

    private Integer depatmentId;

    private String depatmentName;

    private String instructorNum;

    private Integer instructorId;

    private String grade;

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
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
        this.name = name;
    }

    public String getSpecialName() {
        return specialName;
    }

    public void setSpecialName(String specialName) {
        this.specialName = specialName;
    }

    public String getDepatmentName() {
        return depatmentName;
    }

    public void setDepatmentName(String depatmentName) {
        this.depatmentName = depatmentName;
    }

    public String getInstructorNum() {
        return instructorNum;
    }

    public void setInstructorNum(String instructorNum) {
        this.instructorNum = instructorNum;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
