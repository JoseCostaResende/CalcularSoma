package controller;

import gui.util.Alerts;
import gui.util.Constraints;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author jotajota
 */
public class ViewController implements Initializable
{

    @FXML
    private TextField txtNumber1;
    @FXML
    private TextField txtNumber2;
    @FXML
    private Label lbResult;

    @FXML
    private Button btSum;

    @FXML
    public void onBtSumAction()
    {
//        System.out.println("click! ");

//        Alerts.showAlert("Alerta title", "Alert header", "Hello", Alert.AlertType.WARNING);
        try {
            Locale.setDefault(Locale.US);

            double number1 = Double.parseDouble(txtNumber1.getText());

            double number2 = Double.parseDouble(txtNumber2.getText());

            double sum = number1 + number2;

            lbResult.setText(String.format("%.2f", sum));
        }
        catch (NumberFormatException ex) {
            Alerts.showAlert("Error", "Parse error ", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        Constraints.setTextFieldDouble(txtNumber1);
        Constraints.setTextFieldDouble(txtNumber2);

        Constraints.setTextFieldInteger(txtNumber1);
        Constraints.setTextFieldInteger(txtNumber2);

        Constraints.setTextFieldMaxLength(txtNumber1, 12);
        Constraints.setTextFieldMaxLength(txtNumber2, 12);

    }

}
