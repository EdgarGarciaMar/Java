/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probabiPfizer;

import base.Conexion;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sesion.Cliente;

/**
 *
 * @author caleb
 */
public class InicioController implements Initializable {

    public final static String MASCULINO = "Masculino";
    public final static String FEMENINO = "Femenino";

    private String filtro = "";

    Conexion bd;

    @FXML
    private JFXComboBox<String> comboGenero;

    @FXML
    private JFXTextField txtEdad;

    @FXML
    private void pruebaBase(ActionEvent event) {
        int numeroReportes = 0;
        System.out.println("a!");
        try {
            bd.conectar();
            ResultSet rs = bd.ejecutaQuery("select count(*) as 'a' from pfizer;");
            if (rs.next()) {
                numeroReportes = rs.getInt("a");
            }
            bd.cierraConexion();
        } catch (Exception e) {

        }
    }

    @FXML
    void calcularProbabilidad(ActionEvent event) {
        String stringEdad = txtEdad.getText();
        if (Validaciones.StringsNoVacios(stringEdad, filtro)) {
            String genero = filtro.equals(MASCULINO) ? "M" : "F";
            try {
                int edad = Integer.parseInt(stringEdad);
                Cliente.almacenarDatos(genero, obtenerRangoEdad(edad), "");
                System.out.println(Cliente.getGenero() + "\n" + Cliente.getEdad() + "\n" + Cliente.getSintoma());
                
                Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
                FXMLLoader loaderResultados = new FXMLLoader(getClass().getResource("FXMLResultados.fxml"));
                Scene sceneResultados = new Scene(loaderResultados.load());
                stageActual.setScene(sceneResultados);
            } catch (NumberFormatException e) {
                DialogosFX.mostrarError("ProbabiPfizer", "Digite un número en el campo de la edad");
            } catch (IOException ex) {
                Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            DialogosFX.mostrarWarning("ProbabiPfizer", "Llena todos los campos vacios");
        }

    }

    /*
        int edad = Integer.parseInt(txtEdad.getText());
        String sexo = filtro.equals(MASCULINO) ? "M" : "F";
        System.out.println("edad: " + obtenerRangoEdad(edad));
        System.out.println("genero: " + sexo);
        float valorProbabilidad = 0;
        try {
            bd.conectar();
            ResultSet rs = bd.ejecutaQuery("select * from funcion_distribucion_conjunta_pfizer "
                    + "where sex_code = \""+sexo+"\" and age_code = \""+obtenerRangoEdad(edad)+"\" order by probabilidad desc limit 5;");
            while (rs.next()) {
                valorProbabilidad = rs.getFloat("probabilidad");
                System.out.println(rs.getFloat("probabilidad"));
            }
            bd.cierraConexion();
        } catch (Exception e) {

        }
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bd = new Conexion();

        comboGenero.getItems().add(MASCULINO);
        comboGenero.getItems().add(FEMENINO);

        //comboGenero.getSelectionModel().selectFirst();
    }

    public String obtenerRangoEdad(int edad) {
        if (edad < 1) {
            return "<6";
        }
        if (edad >= 1 && edad <= 2) {
            return "1-2";
        }
        if (edad >= 3 && edad <= 5) {
            return "3-5";
        }
        if (edad >= 6 && edad <= 17) {
            return "6-17";
        }
        if (edad >= 18 && edad <= 29) {
            return "18-29";
        }
        if (edad >= 30 && edad <= 39) {
            return "30-39";
        }
        if (edad >= 40 && edad <= 49) {
            return "40-49";
        }
        if (edad >= 50 && edad <= 59) {
            return "50-59";
        }
        if (edad >= 60 && edad <= 64) {
            return "60-64";
        }
        if (edad >= 65 && edad <= 79) {
            return "60-64";
        }
        if (edad >= 80) {
            return "80+ years";
        }
        return "U";
    }

    @FXML
    void generoSeleccionado(ActionEvent event) {
        switch (comboGenero.getValue()) {
            case MASCULINO:
                filtro = MASCULINO;
                break;
            case FEMENINO:
                filtro = FEMENINO;
                break;
        }
        System.out.println(filtro);
    }

}
