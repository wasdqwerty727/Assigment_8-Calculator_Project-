package com.example.assigment8_calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    Calculator calc = new Calculator();
    @FXML
    private TextField input;
    @FXML
    private void onNumberClick(ActionEvent event){
        String val = ((Button)event.getSource()).getText();
        String inval = input.getText();
        input.setText(inval + val);
    }
    @FXML
    private void onOperatorClick(ActionEvent event){
        String val = ((Button)event.getSource()).getText();
        calc.setOperator(val);
        double d = Double.parseDouble(input.getText());
        calc.setOp1(d);
        input.setText("");
    }
    @FXML
    private void onEqualButtonClick() {
        try {
            double result = calc.calculator(calc.getOp1(), Double.parseDouble(input.getText()), calc.getOperator());

            if (calc.getOperator().equals("/")) {
                input.setText(String.valueOf(result));
            } else {
                input.setText(String.valueOf((int) result));
            }
        } catch (DivisionByZeroException e) {
            input.setText("Error division by zero");
        }  catch (Exception e) {
            input.setText("Error");
        }
    }
    @FXML
    private void onClearButtonClick(){
        input.setText("");
        calc.setOp1(0);
    }
}