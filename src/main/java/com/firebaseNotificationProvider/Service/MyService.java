package com.firebaseNotificationProvider.Service;

import com.firebaseNotificationProvider.Model.MyNotification;
import com.firebaseNotificationProvider.Model.MyNotification1;
import com.firebaseNotificationProvider.Model.UserDetails;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class MyService {

    @Autowired
    private FirebaseMessaging firebaseMessaging;

    @Autowired
    private Firestore firestore;



    public String sendFirebaseNotification(MyNotification myNotification) throws ExecutionException, InterruptedException, FirebaseMessagingException {

        DocumentReference documentReference =firestore.collection("user_details").document(myNotification.getUserName());
        ApiFuture<DocumentSnapshot> future=documentReference.get();
        DocumentSnapshot documentSnapshot=future.get();
        System.out.println(documentSnapshot.toString());
        UserDetails userDetails=null;
//        System.out.println(userDetails.getFcmToken());
        if(documentSnapshot.exists()){
            userDetails=documentSnapshot.toObject(UserDetails.class);
        }
        else
            return "Device not registered!!";

        Notification notification=Notification
                .builder()
                .setTitle(myNotification.getTitle())
                .setBody(myNotification.getBody())
                .build();

        Message message = Message
                .builder()
                .setToken(userDetails.getFcmToken())
                .setNotification(notification)
                .build();
        return firebaseMessaging.send(message);

    }

    public ArrayList<String> sendFirebaseNotificationToAll(MyNotification1 myNotification1) throws ExecutionException, InterruptedException, FirebaseMessagingException {
        List<String> responseList=new ArrayList<>();
        for (String s: myNotification1.getUserNames()){

            DocumentReference documentReference =firestore.collection("user_details").document(s);
            ApiFuture<DocumentSnapshot> future=documentReference.get();
            DocumentSnapshot documentSnapshot=future.get();
            System.out.println(documentSnapshot.toString());
            UserDetails userDetails=null;
           // System.out.println(userDetails.getFcmToken());
        if(documentSnapshot.exists()){
            userDetails=documentSnapshot.toObject(UserDetails.class);
        }
        else{
            responseList.add("Device not registered!!");
            continue;
        }

            Notification notification=Notification
                    .builder()
                    .setTitle(myNotification1.getTitle())
                    .setBody(myNotification1.getBody())
                    .build();

            Message message = Message
                    .builder()
                    .setToken(userDetails.getFcmToken())
                    .setNotification(notification)
                    .build();
           responseList.add(firebaseMessaging.send(message));
        }
        return (ArrayList<String>) responseList;
    }
}
