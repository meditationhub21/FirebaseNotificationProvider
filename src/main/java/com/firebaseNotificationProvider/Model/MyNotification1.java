package com.firebaseNotificationProvider.Model;

import java.util.List;

public class MyNotification1 {
     private List<String> userNames;

     private String title;

     private String body;

    public MyNotification1() {
    }

    public MyNotification1(List<String> userNames, String title, String body) {
        this.userNames = userNames;
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        return "MyNotification1{" +
                "userNames=" + userNames +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public List<String> getUserNames() {
        return userNames;
    }

    public void setUserNames(List<String> userNames) {
        this.userNames = userNames;
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
