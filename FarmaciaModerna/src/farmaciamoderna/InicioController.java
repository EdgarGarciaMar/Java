/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmaciamoderna;

import Base.conexion;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author edgargarcia
 */
public class InicioController implements Initializable {

    @FXML private TextField ID;
    @FXML private PasswordField contra;
    //@FXML private Button inic;
    @FXML private Label msj;
    
    conexion bd;
    
    @FXML  
    private void inicio (ActionEvent event){
        String id=ID.getText();
        String con=contra.getText();
        
        try {
            bd.conectar();
            ResultSet rs = bd.ejecutaQuery("call spInicio("+id+","+con+");");
            if(rs.next())
            {
                System.out.println(rs.getString("msj"));
            }
        } 
        catch (SQLException e) {
            System.out.println(e);
        }
        
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       bd=new conexion();
    }    
    
}
