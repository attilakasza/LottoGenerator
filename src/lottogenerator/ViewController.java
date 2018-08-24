package lottogenerator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ViewController implements Initializable {

    private final int MAX = 99;
    private final int MIN = 1;
    private int genNumber1;
    private int genNumber2;
    private int genNumber3;
    private int genNumber4;
    private int genNumber5;

    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;

    @FXML
    private void handleButtonAction(ActionEvent event) {

        generateNumbers();
    }

    private void generateNumbers() {

        //We are generating numbers 
        genNumber1 = 0;
        genNumber2 = 0;
        genNumber3 = 0;
        genNumber4 = 0;
        genNumber5 = 0;

        genNumber1 = getRandomNumber();
        genNumber2 = getRandomNumber();
        genNumber3 = getRandomNumber();
        genNumber4 = getRandomNumber();
        genNumber5 = getRandomNumber();

        //We are setting the generated numbers to the labels 
        label1.setText(String.valueOf(genNumber1));
        label2.setText(String.valueOf(genNumber2));
        label3.setText(String.valueOf(genNumber3));
        label4.setText(String.valueOf(genNumber4));
        label5.setText(String.valueOf(genNumber5));
    }

    private int getRandomNumber() {
        int random = (int) (Math.random() * MAX) + MIN;

        if (random == genNumber1 || random == genNumber2 || random == genNumber3 || random == genNumber4 || random == genNumber5) {
            return getRandomNumber();
        }

        return random;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
