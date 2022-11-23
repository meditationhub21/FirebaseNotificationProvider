package com.firebaseNotificationProvider;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication
public class FirebaseNotificationProviderApplication {

	FileInputStream serviceAccount =
			new FileInputStream("src\\main\\resources\\firebase-service-account.json");

	FirebaseOptions firebaseOptions = FirebaseOptions
			.builder()
			.setCredentials(GoogleCredentials.fromStream(serviceAccount))
			.build();
	FirebaseApp app = FirebaseApp.initializeApp(firebaseOptions, "FirebaseNotificatonProvider");

	public FirebaseNotificationProviderApplication() throws IOException {
	}

	public static void main(String[] args) {

		SpringApplication.run(FirebaseNotificationProviderApplication.class, args);
	}
	@Bean
	FirebaseMessaging firebaseMessaging() throws IOException {
	    return FirebaseMessaging.getInstance(app);
	}
	@Bean
	Firestore firestore() throws IOException {
		return FirestoreClient.getFirestore(app);
	}



}
