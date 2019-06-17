package com.demo.needmanage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Standard {
    private Integer id;

    private String content;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date publishTime;

    public Standard(Integer id, String content, Date publishTime) {
        this.id = id;
        this.content = content;
        this.publishTime = publishTime;
    }

    public Standard() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
}