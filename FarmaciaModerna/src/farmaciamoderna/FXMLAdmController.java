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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tbpane.empleado;

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
    @FXML
    private Tab tab6;
    @FXML
    private TextField id11;
    @FXML
    private PasswordField contra11;
    @FXML
    private Label messajes11;
    @FXML
    private TextField idprovedor;
    @FXML
    private TextField nombreprovedor;
    @FXML
    private TextField telefonoprovedor;
    @FXML
    private TextField paisprovedor;
    @FXML
    private TableColumn<?, ?> columna1;
    @FXML
    private TableColumn<?, ?> columna2;
    @FXML
    private TableColumn<?, ?> columna3;
    @FXML
    private TableColumn<?, ?> columna4;
    @FXML
    private TableColumn<?, ?> columna5;
    @FXML
    private TableColumn<?, ?> columna6;
    @FXML
    private TableColumn<?, ?> columna7;
    @FXML
    private TableColumn<?, ?> columna8;
    @FXML
    private TableColumn<?, ?> columna9;
    @FXML
    private TableColumn<?, ?> columna10;
    @FXML
    private TableColumn<?, ?> columna11;
    @FXML
    private TableColumn<?, ?> columna12;
    @FXML
    private TableColumn<?, ?> columna13;
    
        private List<empleado> empleados;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bd= new conexion();
        empleados = new ArrayList<>();
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
        if(numf.equals(""))messajes1.setText("Por favor no deje campos vacios");
        
        int n=Integer.parseInt(numf);
        

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

    @FXML
    private void salir(ActionEvent event) throws IOException {
                            Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            FXMLLoader loaderInicio = new FXMLLoader(getClass().getResource("Inicio.fxml"));
                            Scene sceneInicio = new Scene(loaderInicio.load());
                            stageActual.setScene(sceneInicio);
    }

    @FXML
    private void registrarProveedor(ActionEvent event) {
        String idproveedor=idprovedor.getText();
        String nombreproveedor=nombreprovedor.getText();
        String telefonoproveedor=telefonoprovedor.getText();
        String paisproveedor=paisprovedor.getText();
        
        String idadmon=id11.getText();
        String contraadmon=contra11.getText();
        if(idproveedor.equalsIgnoreCase("")||nombreproveedor.equalsIgnoreCase("")||telefonoproveedor.equalsIgnoreCase("")||paisproveedor.equalsIgnoreCase("")||idadmon.equalsIgnoreCase("")||contraadmon.equalsIgnoreCase("")){
        messajes11.setText("Por favor no deje campos vacios");
        }else{
            try {
                System.out.println(idproveedor);
                bd.conectar();
                ResultSet rs=bd.ejecutaQuery("call spagregarpro(\""+idadmon+"\",\""+contraadmon+"\", \""+idproveedor+"\",\""+nombreproveedor+"\",\""+telefonoproveedor+"\", \""+paisproveedor+"\");");
                
                if(rs.next()){
                    if(rs.getString("msj").equals("ID incorrecta"))messajes11.setText("ID incorrecta");
                    if(rs.getString("msj").equals("Contraseña incorrecta"))messajes11.setText("Contraseña incorrecta");
                    if(rs.getString("msj").equals("ok"))messajes11.setText("Registro exitoso"+" "+idproveedor+","+nombreproveedor);
                    if(rs.getString("msj").equals("Porfavor verifique, si no es Admin no puede Agregar Provedores."))messajes11.setText("Porfavor verifique, si no es Admin no puede Agregar Provedores.");
                }
                bd.cierraConexion();
                vaciarprovedor();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    public void vaciarprovedor(){
        idprovedor.setText("");
        nombreprovedor.setText("");
        telefonoprovedor.setText("");
        paisprovedor.setText("");
        id11.setText("");
        contra11.setText("");
    }

    @FXML
    private void empleadosview(ActionEvent event) {
        List<empleado> empleados = new ArrayList<>();
        empleado empleadox;
        try {
            /*columna1.setText("ID");
            columna2.setText("Nombres");
            columna3.setText("Apellido Paterno");
            columna4.setText("Apellido Materno");
            columna5.setText("ID de Farmacia laboral");
            columna6.setText("Sucursal");
            columna7.setText("Telefono");
            columna8.setText("Numero");
            columna9.setText("Calle");
            columna10.setText("Colonia");
            columna11.setText("Ciudad");
            columna12.setText("Estado");
            columna13.setText("Codigo Postal");*/
            bd.conectar();
            ResultSet rs=bd.ejecutaQuery("select * from Mostrarempleados");
            while(rs.next()){
                 empleadox = new empleado(rs.getString("ID"),
                        rs.getString("Nombres"),
                        rs.getString("Apellido Paterno"),
                        rs.getString("Apellido Materno"),
                        rs.getString("ID de Farmacia laboral"),
                        rs.getString("Sucursal"),
                        rs.getString("Telefono"),
                        rs.getString("Numero"),
                        rs.getString("Calle"),
                        rs.getString("Colonia"),
                        rs.getString("Ciudad"),
                        rs.getString("Estado"),
                        rs.getString("Codigo Postal")
                );
                empleados.add(empleadox);
                System.out.println(empleadox.getnombre()+empleadox.getapellidop()+empleadox.getapellidom()+empleadox.getsucursal());

            }
            bd.cierraConexion();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    
}
