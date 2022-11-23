package com.firebaseNotificationProvider.Model;

public class MyNotification {

    private String userName;

    private String title;

    private String body;

    public MyNotification() {
    }

    public MyNotification(String userName, String title, String body) {
        this.userName = userName;
        this.title = title;
        this.body = body;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
