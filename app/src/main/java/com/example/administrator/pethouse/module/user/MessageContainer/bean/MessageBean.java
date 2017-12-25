package com.example.administrator.pethouse.module.user.MessageContainer.bean;

/**
 * It.Boss 红叶-QiYe
 */

public class MessageBean {
    private int title;
    private String name;
    private String details;

    public MessageBean(int title, String name, String details) {
        this.title = title;
        this.name = name;
        this.details = details;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
