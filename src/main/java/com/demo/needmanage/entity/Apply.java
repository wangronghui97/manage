package com.demo.needmanage.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Apply {
    private Integer id;

    private String reason;

    private String income;

    private String money;

    private String fatherName;

    private String fatherProfe;

    private String fatherPhone;

    private String motherName;

    private String motherProfe;

    private String motherPhone;

    private String studentName;

    private String studentNum;

    private Date applyTime;

    private Integer typeId;

    private Integer status;

    private String imageAdd;

    public Apply(Integer id, String reason, String income, String money, String fatherName, String fatherProfe, String fatherPhone, String motherName, String motherProfe, String motherPhone, String studentName, String studentNum, Date applyTime, Integer typeId, Integer status, String imageAdd) {
        this.id = id;
        this.reason = reason;
        this.income = income;
        this.money = money;
        this.fatherName = fatherName;
        this.fatherProfe = fatherProfe;
        this.fatherPhone = fatherPhone;
        this.motherName = motherName;
        this.motherProfe = motherProfe;
        this.motherPhone = motherPhone;
        this.studentName = studentName;
        this.studentNum = studentNum;
        this.applyTime = applyTime;
        this.typeId = typeId;
        this.status = status;
        this.imageAdd = imageAdd;
    }

    public Apply() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income == null ? null : income.trim();
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName == null ? null : fatherName.trim();
    }

    public String getFatherProfe() {
        return fatherProfe;
    }

    public void setFatherProfe(String fatherProfe) {
        this.fatherProfe = fatherProfe == null ? null : fatherProfe.trim();
    }

    public String getFatherPhone() {
        return fatherPhone;
    }

    public void setFatherPhone(String fatherPhone) {
        this.fatherPhone = fatherPhone == null ? null : fatherPhone.trim();
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName == null ? null : motherName.trim();
    }

    public String getMotherProfe() {
        return motherProfe;
    }

    public void setMotherProfe(String motherProfe) {
        this.motherProfe = motherProfe == null ? null : motherProfe.trim();
    }

    public String getMotherPhone() {
        return motherPhone;
    }

    public void setMotherPhone(String motherPhone) {
        this.motherPhone = motherPhone == null ? null : motherPhone.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum == null ? null : studentNum.trim();
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImageAdd() {
        return imageAdd;
    }

    public void setImageAdd(String imageAdd) {
        this.imageAdd = imageAdd == null ? null : imageAdd.trim();
    }
}