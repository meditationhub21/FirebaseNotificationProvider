package com.firebaseNotificationProvider.Model;

public class UserDetails {

    private String fcmToken;

    public UserDetails() {
    }

    public UserDetails(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }
}
