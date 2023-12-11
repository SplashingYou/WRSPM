package com.example.mealup;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.spoonacular.RecipesApi;
import com.spoonacular.client.ApiClient;
import com.spoonacular.client.Configuration;
import com.spoonacular.client.auth.ApiKeyAuth;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HelloApplication extends Application {

     public final static String API_KEY = "4899ae64d9d5452582baf069a8478a28";



    public static Scene scene;

    public static Firestore fstore;
    public static FirebaseAuth fauth;

    private final FirestoreContext contxtFirebase = new FirestoreContext();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("new-user-account-signup-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Mealup!");
        stage.setScene(scene);
        stage.show();



        fstore = contxtFirebase.firebase();
        fauth = FirebaseAuth.getInstance();








    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }



    public static void main(String[] args) {
        launch();
    }
}