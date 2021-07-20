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
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author edgargarcia
 */
public class FXMLAdmController implements Initializable {

    conexion bd;
    
    @FXML
    private Tab tab1;
    @FXML
    private TextField idnew;
    @FXML
    private TextField contranew;
    @FXML
    private Label messajes;
    @FXML
    private Button r;
    @FXML
    private Tab tab2;
    @FXML
    private Tab tab3;
    @FXML
    private Tab tab4;
    @FXML
    private Tab tab5;
    @FXML
    private TextField nom;
    @FXML
    private TextField apellpa;
    @FXML
    private TextField apellma;
    @FXML
    private TextField id;
    @FXML
    private PasswordField contra;
    //Reegistrar farmacia
    @FXML
    private Label messajes1;
    @FXML
    private PasswordField contra1;
    @FXML
    private TextField id1;
    @FXML
    private TextField idfar;
    @FXML
    private TextField nomfar;
    @FXML
    private TextField cp;
    @FXML
    private TextField phone;
    @FXML
    private TextField edo;
    @FXML
    private TextField city;
    @FXML
    private TextField col;
    @FXML
    private TextField calle;
    @FXML
    private TextField num;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bd= new conexion();
    }    

    @FXML
    private void registrar(ActionEvent event) {
        String nombre= nom.getText();
        String apellidopa=apellpa.getText();
        String apellidoma=apellma.getText();
        String idNew=idnew.getText();
        String connew=contranew.getText();
        String idAdm=id.getText();
        String contrasena=contra.getText();
        
        if(nombre.equalsIgnoreCase("") ||apellidopa.equalsIgnoreCase("")||apellidoma.equalsIgnoreCase("")||idNew.equalsIgnoreCase("")||idAdm.equalsIgnoreCase("")||contrasena.equalsIgnoreCase("")||connew.equalsIgnoreCase("")){
            messajes.setText("Por favor no deje campos vacios");
        }else{

            try {
                bd.conectar();
                //call spCreaAdmin("edgargarcia@farma.com", 'Bon12', "Mario@farma.com","hola","Perez","Ju","Mario");
                ResultSet rs = bd.ejecutaQuery("call spCreaAdmin(\""+idAdm+"\", \""+contrasena+"\", \""+idNew+"\",\""+connew+"\",\""+apellidopa+"\",\""+apellidoma+"\",\""+nombre+"\");");
                if(rs.next()){
                    if(rs.getString("msj").equals("ID incorrecta"))messajes.setText("ID incorrecta");
                    if(rs.getString("msj").equals("Contraseña incorrecta"))messajes.setText("Contraseña incorrecta");
                    if(rs.getString("msj").equals("Porfavor verifique, si no es Admin no puede agregar a mas Admins."))messajes.setText("Porfavor verifique, si no es Admin no puede agregar a mas Admins.");
                    if(rs.getString("msj").equals("ok"))messajes.setText("Registro exitoso, "+idNew+","+nombre);
                }
                bd.cierraConexion();
                /*nom.setText("");
                apellpa.setText("");
                apellma.setText("");
                idnew.setText("");
                contranew.setText("");
                id.setText("");
                contra.setText("");*/
                vaciarregistraadm();
            } catch (SQLException e) {
                System.out.println(e);
                messajes.setText("El ID ya existe.");
            }
        
        }
    }

    @FXML
    private void registrarfarma(ActionEvent event) {
        String numf=num.getText();
        String callf=calle.getText();
        String colf=col.getText();
        String ciudad=city.getText();
        String estado=edo.getText();
        String CP=cp.getText();
        String nombref=nomfar.getText();
        String IDf=idfar.getText();
        String telefono=phone.getText();
        
        String ida=id1.getText();
        String c=contra1.getText();
        
        
        if(numf.equals("")){
            messajes1.setText("Por favor no deje campos vacios");
        }else{
           int n= Integer.parseInt(numf); 
        }
        if(numf.equalsIgnoreCase("")||callf.equalsIgnoreCase("")||colf.equalsIgnoreCase("")||ciudad.equalsIgnoreCase("")||estado.equalsIgnoreCase("")||CP.equalsIgnoreCase("")||nombref.equalsIgnoreCase("")||IDf.equalsIgnoreCase("")||telefono.equalsIgnoreCase("")||ida.equalsIgnoreCase("")||c.equalsIgnoreCase("")){
            messajes1.setText("Por favor no deje campos vacios");
        }else{
            try {
                bd.conectar();
                
                ResultSet rs=bd.ejecutaQuery("call spCreafarm(\""+ida+"\", \""+c+"\", \""+IDf+"\",\""+telefono+"\", \""+nombref+"\",\""+CP+"\",\""+estado+"\",\""+ciudad+"\",\""+colf+"\",\""+n+"\",\""+callf+"\");");
                if(rs.next()){
                    if(rs.getString("msj").equals("ID incorrecta"))messajes1.setText("ID incorrecta");
                    if(rs.getString("msj").equals("Contraseña incorrecta"))messajes1.setText("Contraseña incorrecta");
                    if(rs.getString("msj").equals("ok"))messajes1.setText("Registro exitosos"+" "+nombref+","+IDf);
                    if(rs.getString("msj").equals("Porfavor verifique, si no es Admin no puede Agregar Farmacias."))messajes1.setText("Porfavor verifique, si no es Admin no puede Agregar Farmacias.");
                }
                bd.cierraConexion();
                /*num.setText("");
                calle.setText("");
                col.setText("");
                city.setText("");
                edo.setText("");
                cp.setText("");
                nomfar.setText("");
                idfar.setText("");
                phone.setText("");
                id1.setText("");
                contra1.setText("");*/
                vaciarregistrafarm();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    private void vaciarregistraadm(){
                nom.setText("");
                apellpa.setText("");
                apellma.setText("");
                idnew.setText("");
                contranew.setText("");
                id.setText("");
                contra.setText("");
    }
    private void vaciarregistrafarm(){
                num.setText("");
                calle.setText("");
                col.setText("");
                city.setText("");
                edo.setText("");
                cp.setText("");
                nomfar.setText("");
                idfar.setText("");
                phone.setText("");
                id1.setText("");
                contra1.setText("");
    }
    
}
