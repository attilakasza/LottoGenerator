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
        System.out.println("You clicked me!");
        label1.setText(String.valueOf(getRandomNumber()));
        label2.setText(String.valueOf(getRandomNumber()));
        label3.setText(String.valueOf(getRandomNumber()));
        label4.setText(String.valueOf(getRandomNumber()));
        label5.setText(String.valueOf(getRandomNumber()));

    }
    
    private int getRandomNumber(){ 
      int random = (int) (Math.random() * MAX) + MIN; 
      return random;      
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
