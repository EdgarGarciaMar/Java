/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmaciamoderna;

import Base.conexion;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author edgargarcia
 */
public class InicioController implements Initializable {

    @FXML private TextField ID;
    @FXML private PasswordField contra;
    @FXML private Label msjp;
    
    conexion bd;
    
    @FXML  
    private void inicio (ActionEvent event) throws IOException{
        String id=ID.getText();
        String con=contra.getText();
        
        if(id.equalsIgnoreCase("") && con.equalsIgnoreCase("")){
        msjp.setText("Porfavor no deje campos vacios");
        }else{
        try {
            bd.conectar();
            ResultSet rs = bd.ejecutaQuery("call spInicio(\""+id+"\", \""+con+"\");");
            if(rs.next())
            { 
                if(rs.getString("msj").equals("admin")){
                System.out.println("Inicio Admin");
                            Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            FXMLLoader loaderInicio = new FXMLLoader(getClass().getResource("FXMLAdm.fxml"));
                            Scene sceneInicio = new Scene(loaderInicio.load());
                            stageActual.setScene(sceneInicio);
                
                }
                if(rs.getString("msj").equals("empleado")){
                System.out.println("Inicio Empleado");
                
                }
                if(rs.getString("msj").equals("ID o contraseña incorecta")){
                String s=rs.getString("msj");
                msjp.setText(s);
                }
            }
            bd.cierraConexion();            
        } 
        catch (SQLException e) {
            System.out.println(e);
        }
        
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       bd=new conexion();
    }    
    
}
