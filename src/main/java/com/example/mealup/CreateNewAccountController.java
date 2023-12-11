package com.example.mealup;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.WriteResult;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateNewAccountController implements Initializable {

    @FXML
    private TextField username_signup_TextField;

    @FXML
    private TextField password_signup_TextField;
    @FXML
    private TextField firstname_signup_TextField;

    @FXML
    private TextField age_signup_TextField;

    @FXML
    private TextField lastname_signup_TextField;


    private boolean isValidUsername(String username){
        String regex = "^[A-Za-z][A-Za-z0-9_]{7,29}$";
        Pattern p = Pattern.compile(regex);

        if(username == null){
            return false;

        }

        Matcher m = p.matcher(username);

        return m.matches();


    }



    private boolean isValidPassword(String password)
    {

        // Regex to check valid password.
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

    @FXML
    private CheckBox termsCheckBox;

    @FXML
    private Slider exerciseLevelSlider;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        exerciseLevelSlider.setMax(2);
        exerciseLevelSlider.setMin(0);
        exerciseLevelSlider.setValue(1);
        exerciseLevelSlider.setMinorTickCount(0);
        exerciseLevelSlider.setMajorTickUnit(1);
        exerciseLevelSlider.setSnapToTicks(true);
        exerciseLevelSlider.setShowTickMarks(true);
        exerciseLevelSlider.setShowTickLabels(true);

        exerciseLevelSlider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double n) {
                if (n < 0.5) return "None";
                if (n < 1.5) return "Intermediate";
                if (n < 2.5) return "Advanced";

                return "Advanced";


            }

            @Override
            public Double fromString(String s) {
                switch (s){
                    case "Novice":
                        return 0d;
                    case "Intermediate":
                        return 1d;
                    case "Advanced":
                        return 2d;

                    default:
                        return 2d;
                }
            }
        });
        exerciseLevelSlider.setMinWidth(380);


            }



    public void addData() {

        DocumentReference docRef = HelloApplication.fstore.collection("User Accounts").document(username_signup_TextField.getText() + " " + password_signup_TextField.getText());
        // Add document data  with id "alovelace" using a hashmap
        Map<String, String> data = new HashMap<>();
        data.put("Username", username_signup_TextField.getText().trim());
        data.put("Password", password_signup_TextField.getText());
        //asynchronously write data
        ApiFuture<WriteResult> result = docRef.set(data);
    }


    @FXML
    private void handleCreateAccountButton() throws IOException {
        User user = new User();
        user.setFirstName(firstname_signup_TextField.getText());
        user.setLastName(lastname_signup_TextField.getText());
        user.setUsername(username_signup_TextField.getText());
        user.setPassword(password_signup_TextField.getText());
        user.setAge(Integer.parseInt(age_signup_TextField.getText()));
        addData();
        HelloApplication.setRoot("main-app");




    }




        }




