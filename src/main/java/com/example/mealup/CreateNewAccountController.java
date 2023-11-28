package com.example.mealup;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateNewAccountController implements Initializable {

    private static boolean isValidPassword(String password)
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

    @FXML
    public void setExcerciseSlider(){
        exerciseLevelSlider.setMax(3);
        exerciseLevelSlider.setMin(0);
        exerciseLevelSlider.setValue(1);



    }


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


        }




