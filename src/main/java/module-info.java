module com.example.assigment8_calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assigment8_calculator to javafx.fxml;
    exports com.example.assigment8_calculator;
}