/*
3.-Codificar un applet que tenga un botón, un campo de entrada y una etiqueta. 
El campo de entrada es para introducir el sueldo del trabajador y que cuando 
el usuario presione el boton calcule cual seria el salario si se le da un aumento 
del 15% si su sueldo es inferior a $3000 y 10% en caso contrario. Imprima el nuevo 
sueldo del trabajador en la zona de status y/o la etiqueta.

Diagrama UML:
=============================|
            Salarios         |
=============================|                            ================
-b                           |__________________________ \ | JFrame      |  
-l                           |                           /=================
-result                      |
-m                           |
-s                           |                              ===========================
-a                           |---------------------------\   |      <<Interface>>     |
-----------------------------|                           /   |      ActionListener    |
                                                            ===========================
                                                            | + actionPerformed():Void|
                                                            ---------------------------
 */
package salarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Salarios extends JFrame implements ActionListener{
JButton b;
JTextField l;
JLabel result,m,s,a;

  public Salarios(){
      super("Calculadora de Salarios");
      setLayout(null);
      setSize(600,350);
      
      m = new JLabel("Ingresa tu salario actual para conocer tu nuevo salario");
      m.setBounds(15, 5, 900, 20);
      add(m);
      
      l = new JTextField();//campo para introducir los datos
      l.setBounds(50,100,200,20); 
      add(l);
      
      b = new JButton("Calcular"); //boton
      b.setBounds(50,150,100,40);
      b.addActionListener(this);
      add(b);
      
      result = new JLabel("_________________________");//etiqueta de resultado
      result.setBounds(350,100,200,20);
      add(result);
      
      s= new JLabel("$");
      s.setBounds(41, 100, 200, 20);
      add(s);
      
      a = new JLabel("Tu nuevo salario con aumento es:");
      a.setBounds(350, 86, 200, 20);
      add(a);
  }
  
  
@Override
    public void actionPerformed(ActionEvent e) {
       double salario = Double.parseDouble(l.getText());
       if (salario< 3000){
           salario = salario+(salario*0.15);
       }
       else{
           salario = salario+(salario*0.10);
       }
       result.setText("$"+salario+"MN");
    }

    public static void main(String[] args) {
        Salarios ventana = new Salarios();        
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    }
}
