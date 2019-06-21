package com.design_mode.behavioral_patterns.observer_pattern.model;

/**
 * 消息模型
 */
public class Message {
    private String author;//作者
    private String title;//书名
    private String desc;//描述

    public Message(String author, String title, String desc) {
        this.author = author;
        this.title = title;
        this.desc = desc;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
