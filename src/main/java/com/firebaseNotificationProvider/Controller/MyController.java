package com.firebaseNotificationProvider.Controller;

import com.firebaseNotificationProvider.Model.MyNotification;
import com.firebaseNotificationProvider.Model.MyNotification1;
import com.firebaseNotificationProvider.Service.MyService;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @PostMapping("/sendNotification")
    public ResponseEntity<String> sendNotification(@RequestBody MyNotification myNotification) throws ExecutionException, InterruptedException, FirebaseMessagingException {
       String response = myService.sendFirebaseNotification(myNotification);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @PostMapping("/sendNotificationToAll")
    public ResponseEntity<List<String>> sendNotificationToAll(@RequestBody MyNotification1 myNotification1) throws ExecutionException, InterruptedException, FirebaseMessagingException {
        System.out.println(myNotification1);
        List<String> myList=myService.sendFirebaseNotificationToAll(myNotification1);
        return new ResponseEntity<>(myList,HttpStatus.OK);
    }
}
