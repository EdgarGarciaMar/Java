/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medidor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author edgargarcia
 */
public class FXMLvistaController implements Initializable {
    
    @FXML
    private Label Resultado;
    @FXML
    private TextField num;
    @FXML
    private TextField mm;
    @FXML
    private void B1(ActionEvent event) {
        double numfallas = Double.parseDouble(num.getText());
        double mmlong = Double.parseDouble(mm.getText());
        numfallas = numfallas * mmlong;
        Resultado.setText("El resultado sera u = "+ numfallas);
        num.setText("");
        mm.setText("");
    }
    @FXML
    private void B2(ActionEvent event){
        double numfallas = Double.parseDouble(num.getText());
        double mmlong = Double.parseDouble(mm.getText());
        double prome;
            numfallas = numfallas * mmlong;
            prome = 1/(Math.pow(2.72,numfallas));
        Resultado.setText("El promedio sera P( 0 | "+ numfallas +" ) = "+ prome);
        num.setText("");
        mm.setText("");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
