package lottogenerator;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class ViewController implements Initializable {

    private final int MAX = 99;
    private final int MIN = 1;
    private int genNumber1;
    private int genNumber2;
    private int genNumber3;
    private int genNumber4;
    private int genNumber5;
    private int selNumber1;
    private int selNumber2;
    private int selNumber3;
    private int selNumber4;
    private int selNumber5;

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
    private TextField input1;
    @FXML
    private TextField input2;
    @FXML
    private TextField input3;
    @FXML
    private TextField input4;
    @FXML
    private TextField input5;
    @FXML
    private Label resultLabel;
    @FXML
    private Pane basePane;
    @FXML
    private Pane alertPane;
    @FXML
    private Label alertText;
    @FXML
    private Text numbers;
    
    @FXML
    private void handleAlertButton(ActionEvent event) {
        basePane.setDisable(false);
        basePane.setOpacity(1);
        alertPane.setVisible(false);
        alertText.setText("");
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        generateNumbers();
        checkNumbers();
    }

    @FXML
    private void handleExit(MouseEvent event) {
        System.exit(0);
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
        label1.setText(String.valueOf(genNumber1) + ",");
        label2.setText(String.valueOf(genNumber2) + ",");
        label3.setText(String.valueOf(genNumber3) + ",");
        label4.setText(String.valueOf(genNumber4) + ",");
        label5.setText(String.valueOf(genNumber5));
        numbers.setVisible(true);
    }

    private void checkNumbers() {

        //Are they numbers? 
        try {
            selNumber1 = Integer.parseInt(input1.getText());
            selNumber2 = Integer.parseInt(input2.getText());
            selNumber3 = Integer.parseInt(input3.getText());
            selNumber4 = Integer.parseInt(input4.getText());
            selNumber5 = Integer.parseInt(input5.getText());
        } catch (Exception e) {
            alert("Nem jó számot adtál meg!");
            return;
        }

        //Are they unique? 
        HashSet<Integer> selectedNumbers = new HashSet<>();
        selectedNumbers.add(selNumber1);
        selectedNumbers.add(selNumber2);
        selectedNumbers.add(selNumber3);
        selectedNumbers.add(selNumber4);
        selectedNumbers.add(selNumber5);
        if (selectedNumbers.size() < 5) {
            alert("A számoknak különbözőnek kell lenniük!");
            return;
        }

        ArrayList<Integer> userNumbers = new ArrayList<>(selectedNumbers);

        //Are they between 1-99? 
        for (Integer number : userNumbers) {
            if (number < MIN || number > MAX) {
                alert("Minden számnak 1 és 99 között kell lennie!");
                return;
            }
        }

        checkResult(userNumbers);
    }

    private void checkResult(ArrayList<Integer> userNumbers) {
        int result = 0;
        for (int i = 0; i < userNumbers.size(); i++) {
            if (userNumbers.get(i) == genNumber1 || userNumbers.get(i) == genNumber2 || userNumbers.get(i) == genNumber3 || userNumbers.get(i) == genNumber4 || userNumbers.get(i) == genNumber5) {
                result++;
            }
        }
        
        switch (result) {
            case 0:
                resultLabel.setText("Sajnos nem nyertél semmit.");
                break;
            case 1:
                resultLabel.setText("Egyesed van a lottón.");
                break;
            case 2:
                resultLabel.setText("Kettesed van a lottón.");
                break;
            case 3:
                resultLabel.setText("Hármasod van a lottón.");
                break;
            case 4:
                resultLabel.setText("Négyesed van a lottón.");
                break;
            case 5:
                resultLabel.setText("ÖTÖSÖD VAN! Gratulálok!");
                break;
        }
    }

    private int getRandomNumber() {
        int random = (int) (Math.random() * MAX) + MIN;

        if (random == genNumber1 || random == genNumber2 || random == genNumber3 || random == genNumber4 || random == genNumber5) {
            return getRandomNumber();
        }

        return random;
    }

    private void alert(String text) {
        basePane.setDisable(true);
        basePane.setOpacity(0.3);
        alertPane.setVisible(true);
        alertText.setText(text);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
