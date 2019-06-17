package com.demo.needmanage.comment;

public enum MessageCode {
    ADD_SUCCESS(200,"添加成功"),
    ADD_FAIL(0,"添加失败"),
    FIND_FAIL(0,"查询失败"),
    FIND_SUCCESS(200,"查询成功"),
    DELETE_FAIL(0,"删除失败"),
    DELETE_SUCCESS(200,"删除成功"),
    UPDATE_FAIL(0,"更新失败"),
    UPDATE_SUCCESS(200,"更新成功"),
    LOGIN_SUCCESS(200,"登录成功"),
    LOGIN_FAIL(0,"用户名不存在或密码错误"),
    LOGIN_IN(200,"账号已登录"),
    LOGIN_OUT(0,"账号未登录"),
    SIGNOUT_SUCCESS(0,"登出成功"),
    SINGOUT_FAIL(200,"登出失败"),
    UPDATE_PASSWORD_FAIL_OLD(0,"旧密码输出错误"),
    UPDATE_PASSWORD_FAIL(0,"密码修改失败"),
    UPDATE_PASSWORD_SUCCESS(200,"密码修改成功"),
    ADDFAIL_BY_STUDENTNUM(0,"该学号已存在"),
    ADDFAIL_BY_CLASS(0,"该班级已存在"),
    ADDFAIL_BY_SPECIAL(0,"该专业已存在"),
    ADDFAIL_BY_DEPATMENT(0,"该系别已存在"),
    ADDFAIL_BY_INFO(0,"信息不完整"),
    UPLOAD_SUCCESS(200,"上传图片成功"),
    UPLOAD_FAIL(0,"上传图片失败");

    private int code;

    private String message;

    MessageCode(int code,String message){
        this.code=code;
        this.message=message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
