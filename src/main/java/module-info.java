module com.example.mealup {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mealup to javafx.fxml;
    exports com.example.mealup;
}