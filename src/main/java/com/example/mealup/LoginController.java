package com.example.mealup;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginController implements Initializable {
    private boolean key;

    private User user;

    private final ObservableList<User> listOfUsers = FXCollections.observableArrayList();


    @FXML
    private static TextField usernameField;
    @FXML
    private static PasswordField passwordField;
    @FXML
    private void loginAction(ActionEvent event) {
        String username = usernameField.getText().trim();
        String password = passwordField.getText();
        if (username.isEmpty()) {
            showAlertMessage(Alert.AlertType.ERROR, "Username Required!",
                    "Please enter your username");
            return;
        }
        if (password.isEmpty()) {
            showAlertMessage(Alert.AlertType.ERROR, "Password Required!",
                    "Please enter your password");
            return;
        }





        showAlertMessage(Alert.AlertType.INFORMATION, "Details sent to database!",
                "Username and password have been sent to database for validation");
    }
    public static void showAlertMessage(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    public boolean isValidPassword(String password)
    {


        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";


        Pattern p = Pattern.compile(regex);

        // If the password is empty
        // return false
        if (password == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(password);

        // Return if the password
        // matched the ReGex
        return m.matches();
    }



    public boolean readFirebase()
    {
         key = false;

        //asynchronously retrieve all documents
        ApiFuture<QuerySnapshot> future =  HelloApplication.fstore.collection("Persons").get();
        // future.get() blocks on response
        List<QueryDocumentSnapshot> documents;
        try
        {
            documents = future.get().getDocuments();
            if(documents.size()>0)
            {
                System.out.println("Outing data from firabase database....");
                listOfUsers.clear();
                for (QueryDocumentSnapshot document : documents)
                {
                    System.out.println(document.getData().get("Username"));
                    System.out.println(document.getData().get("Password"));


                }
            }
            else
            {
                System.out.println("No data");
            }
            key=true;

        }
        catch (InterruptedException | ExecutionException ex)
        {
            ex.printStackTrace();
        }
        return key;
    }

    public static void addData() {

        DocumentReference docRef = HelloApplication.fstore.collection("User Accounts").document("Spc");
        // Add document data  with id "alovelace" using a hashmap
        Map<String, String> data = new HashMap<>();
        data.put("Username", usernameField.getText().trim());
        data.put("Password", passwordField.getText());
        //asynchronously write data
        ApiFuture<WriteResult> result = docRef.set(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {







    }
}