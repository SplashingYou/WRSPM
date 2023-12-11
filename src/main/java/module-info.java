module com.example.mealup {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.client;
    requires google.cloud.firestore;
    requires firebase.admin;
    requires com.google.auth.oauth2;
    requires java.logging;
    requires com.google.api.apicommon;
    requires com.google.auth;
    requires google.cloud.core;
    requires java.sql;
    requires json.simple;


    opens com.example.mealup to javafx.fxml;
    exports com.example.mealup;
}