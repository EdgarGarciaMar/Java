/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiperros;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;




/**
 *
 * @author edgar
 */
public class GUIPerros extends JFrame implements ActionListener {
conexion con;
JButton b1,b2,b3,b4;
JTextField t1,t2,t3,t4,t5;
JLabel l1,l2,l3,l4,l5;
JPanel p1,p2;
public GUIPerros (){
    super("Perros");
    this.setSize(500,500); 
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLayout(new GridLayout(2,1));
    superior();
    this.add(p1);
    inferior();
    this.add(p2);
}
public void superior(){
    p1 = new JPanel();
    p1.setLayout(new GridLayout(5,2));
    l1= new JLabel("Nombre");
    p1.add(l1);
    t1 = new JTextField(50);//Nombre
    p1.add(t1);
    
    l2= new JLabel("Raza");
    p1.add(l2);
    t2 = new JTextField(50);//Raza
    p1.add(t2);
    
    l3= new JLabel("Edad");
    p1.add(l3);
    t3 = new JTextField(50);//Edad
    p1.add(t3);
    
    l4= new JLabel("Genero");
    p1.add(l4);
    t4 = new JTextField(50);//Genero
    p1.add(t4);
    
    l5= new JLabel("ID");
    p1.add(l5);
    t5 = new JTextField(50);//ID
    p1.add(t5);
}

public void inferior(){
    p2 = new JPanel();
    p2.setLayout(new GridLayout(1,4));
    b1 = new JButton("Conectar");
    p2.add(b1);
    b1.addActionListener(this);
    b2 = new JButton("Desconectar");
    p2.add(b2);
    b2.addActionListener(this);
    b3 = new JButton("Insertar");
    p2.add(b3);
    b3.addActionListener(this);
    b4 = new JButton("Consulta");
    p2.add(b4);
    b4.addActionListener(this);
}
public void vaciarcampos(){
    t1.setText("");
    t2.setText("");
    t3.setText("");
    t4.setText("");
    t5.setText("");
}

    @Override
    public void actionPerformed(ActionEvent e) { 
        if(e.getSource()== b1){
          con = new conexion();
        }
        if (e.getSource()== b2){
            try {
             con.desconectar();
            } catch (SQLException ex) {
                System.out.println(ex);
            }  
        }
        if(e.getSource()== b3){
            int id =Integer.parseInt (t5.getText());
            String nombre = t1.getText();
            String raza = t2.getText();
            int edad = Integer.parseInt (t3.getText());
            String genero = t4.getText();
            vaciarcampos();
            try {
                con.insertar(id, nombre, raza, edad, genero);
                System.out.println("Se agrego: "+"ID:"+id+" "+"Nombre:"+nombre+" "+"Raza:"+raza+" "+"Edad:"+edad+" "+"Genero:"+genero);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
    }
        if(e.getSource()== b4){
            try {
                con.consulta();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
     
    }

       public static void main(String[] args) {
       new GUIPerros();
    }
}
