package com.demo.needmanage.dto;

public class ApplyDto {

    //学生姓名
    private String studentName;

    //学号
    private String studentNum;

    //资助类型
    private String typeName;

    //资助金额
    private String money;

    //系别
    private String depatmentName;

    //专业
    private String specialName;

    //班级
    private String className;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getDepatmentName() {
        return depatmentName;
    }

    public void setDepatmentName(String depatmentName) {
        this.depatmentName = depatmentName;
    }

    public String getSpecialName() {
        return specialName;
    }

    public void setSpecialName(String specialName) {
        this.specialName = specialName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "ApplyDto{" +
                "studentName='" + studentName + '\'' +
                ", studentNum='" + studentNum + '\'' +
                ", typeName='" + typeName + '\'' +
                ", money='" + money + '\'' +
                ", depatmentName='" + depatmentName + '\'' +
                ", specialName='" + specialName + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
