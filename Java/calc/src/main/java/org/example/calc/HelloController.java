package org.example.calc;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;

public class HelloController {

    @FXML
    private TextField campoPriNum;

    @FXML
    private TextField campoSegNum;


    @FXML
    private TextArea resultado;

    @FXML
    void onDiv() {
        int A = Integer.parseInt(campoPriNum.getText());
        int B = Integer.parseInt(campoSegNum.getText());
        String answer;
        try {
            int division = A / B;
            answer = division + "";
        } catch (ArithmeticException exception) {
            answer = "No es posible dividir por cero. Intente nuevamente"+ exception.getLocalizedMessage();
        }
        resultado.setText(answer);
    }


    @FXML
    void onMult() {
        int A = Integer.parseInt(campoPriNum.getText());
        int B = Integer.parseInt(campoSegNum.getText());
        int C;
        C = A * B;
        resultado.setText(String.valueOf(C));

    }

    @FXML
    void onRes() {
        int A = Integer.parseInt(campoPriNum.getText());
        int B = Integer.parseInt(campoSegNum.getText());
        int C;
        C = A - B;
        resultado.setText(String.valueOf(C));

    }

    @FXML
    void onSum() {
        int A = Integer.parseInt(campoPriNum.getText());
        int B = Integer.parseInt(campoSegNum.getText());
        int C;
        C = A + B;
        resultado.setText(String.valueOf(C));
    }
}



