package com.example.mealup;

import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginController implements Initializable {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
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

        // Compile the ReGex
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {







    }
}