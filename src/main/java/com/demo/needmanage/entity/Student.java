package com.demo.needmanage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Student {
    private Integer id;

    private String studentNum;

    private String name;

    private Integer sex;


    private String password;

    private Integer specialId;

    private Integer classId;

    private String address;

    private Integer depatmentId;

    private String grade;

    public Student(Integer id, String studentNum, String name, Integer sex, String password, Integer specialId, Integer classId, String address, Integer depatmentId, String grade) {
        this.id = id;
        this.studentNum = studentNum;
        this.name = name;
        this.sex = sex;
        this.password = password;
        this.specialId = specialId;
        this.classId = classId;
        this.address = address;
        this.depatmentId = depatmentId;
        this.grade = grade;
    }

    public Student() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum == null ? null : studentNum.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getSpecialId() {
        return specialId;
    }

    public void setSpecialId(Integer specialId) {
        this.specialId = specialId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getDepatmentId() {
        return depatmentId;
    }

    public void setDepatmentId(Integer depatmentId) {
        this.depatmentId = depatmentId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }
}