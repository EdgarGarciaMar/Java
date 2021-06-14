/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probabiPfizer;

import base.Conexion;
import com.jfoenix.controls.JFXAutoCompletePopup;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sesion.Cliente;
import sesion.Sintoma;

/**
 * FXML Controller class
 *
 * @author caleb
 */
public class ResultadosController implements Initializable {

    Conexion bd;
    private ObservableList<String> listSintomas = FXCollections.observableArrayList();
    private ArrayList<Sintoma> arraySintomasCalculados;

    XYChart.Series dataSeries1;

    @FXML
    private Label labelTitulo;

    @FXML
    private Label labelContenido;

    @FXML
    private Pane paneGrafica;

    @FXML
    private BarChart<?, ?> barChartResultado;

    @FXML
    private JFXComboBox<String> comboBoxReacciones;

    @FXML
    private JFXButton buttonCalcular;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        arraySintomasCalculados = new ArrayList<>();
        bd = new Conexion();
        popularCombobox();

        comboBoxReacciones.setEditable(true);

        JFXAutoCompletePopup<String> autoCompletePopup = new JFXAutoCompletePopup<>();
        autoCompletePopup.getSuggestions().addAll(comboBoxReacciones.getItems());

        //SelectionHandler sets the value of the comboBox
        autoCompletePopup.setSelectionHandler(event -> {
            comboBoxReacciones.setValue(event.getObject());
        });

        TextField editor = comboBoxReacciones.getEditor();
        editor.addEventHandler(KeyEvent.ANY, event -> {
            //The filter method uses the Predicate to filter the Suggestions defined above
            //I choose to use the contains method while ignoring cases
            autoCompletePopup.filter(item -> item.toLowerCase().contains(editor.getText().toLowerCase()));
            //Hide the autocomplete popup if the filtered suggestions is empty or when the box's original popup is open
            if (autoCompletePopup.getFilteredSuggestions().isEmpty() || comboBoxReacciones.showingProperty().get()) {
                autoCompletePopup.hide();
            } else {
                autoCompletePopup.show(editor);
            }
        });

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Sintomas");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Probabilidad");

        dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Sintomas");

        obtenerReaccionesAdversas();

        graficar();

        escribirResultados();

    }

    public void obtenerReaccionesAdversas() {
        try {
            bd.conectar();
            System.out.println(Cliente.getGenero() + "\n" + Cliente.getEdad() + "\n" + Cliente.getSintoma());
            ResultSet rs = bd.ejecutaQuery("select * from funcion_distribucion_conjunta_pfizer where sex_code = \"" + Cliente.getGenero() + "\" and age_code = \"" + Cliente.getEdad() + "\" order by probabilidad desc limit 7;");
            while (rs.next()) {
                arraySintomasCalculados.add(new Sintoma(rs.getString("Symptoms"), rs.getInt("events_reported"), rs.getBigDecimal("probabilidad")));
                //dataSeries1.getData().add(new XYChart.Data(rs.getString("Symptoms"), rs.getBigDecimal("probabilidad")));
            }
            //barChartResultado.getData().add(dataSeries1);
            bd.cierraConexion();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void popularCombobox() {
        try {
            bd.conectar();
            ResultSet rs = bd.ejecutaQuery("select distinct Symptoms from funcion_distribucion_conjunta_pfizer;");
            while (rs.next()) {
                listSintomas.add(rs.getString("Symptoms"));
            }
            comboBoxReacciones.setItems(listSintomas);
            bd.cierraConexion();
        } catch (Exception e) {

        }
    }

    public void escribirResultados() {
        String resultado = "";
        if (arraySintomasCalculados.size() == 1) {
            labelTitulo.setText("Sintoma especifico:");
        } else {
            labelTitulo.setText("Reacciones adversas con mas probabilidades de presentar:");
        }
        int i = 1;
        for (Sintoma sintomax : arraySintomasCalculados) {
            resultado += i + ". " + sintomax.getNombre() + " - " + sintomax.getPorcentajeProbabilidad().toString() + "% (" + sintomax.getNumeroEventos() + " eventos reportados)\n\n";
            i++;
        }
        labelContenido.setText(resultado);
    }

    @FXML
    void calcularSintoma(ActionEvent event) {
        try {
            bd.conectar();
            ResultSet rs = bd.ejecutaQuery("select * from funcion_distribucion_conjunta_pfizer \n"
                    + "where Symptoms = \""+comboBoxReacciones.getValue()+"\" and sex_code = \"" + Cliente.getGenero() + "\" and age_code = \"" + Cliente.getEdad() + "\";");
            while (rs.next()) {
                arraySintomasCalculados.clear();
                arraySintomasCalculados.add(new Sintoma(rs.getString("Symptoms"), rs.getInt("events_reported"), rs.getBigDecimal("probabilidad")));
            }
            bd.cierraConexion();
            graficar();
            escribirResultados();
        } catch (Exception e) {

        }
    }

    public void graficar() {
        dataSeries1.getData().clear();
        barChartResultado.getData().clear();
        for (Sintoma sintoma : arraySintomasCalculados) {
            dataSeries1.getData().add(new XYChart.Data(sintoma.getNombre(), sintoma.getPorcentajeProbabilidad()));
        }
        barChartResultado.getData().addAll(dataSeries1);
    }
    
    @FXML
    public void irAInicio(ActionEvent event) {
        Cliente.limpiarDatos();
        try {
            Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loaderInicio = new FXMLLoader(getClass().getResource("FXMLInicio.fxml"));
            Scene sceneInicio = new Scene(loaderInicio.load());
            stageActual.setScene(sceneInicio);
        } catch (IOException ex) {
            Logger.getLogger(ResultadosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
