/*
García Marciano Edgar
Practica N°1
GUI Básica
Opción N° 3 Conversión de temperaturas
5/11/2020
2CM3
Programación Orientada a Objetos
Tecla Parra Roberto
*/


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Temperatura extends JFrame implements ActionListener {
JButton b,b2;
JTextField l;
JLabel result,m,a;

    public Temperatura(){
      super("Conversion de Temperaturas");//titulo
      setLayout(null);
      setSize(600,350);
      
      m = new JLabel("Ingresa la temperatura que deseas convertir.");//instrucciones
      m.setBounds(15, 5, 900, 20);
      add(m);
      
      l = new JTextField();//campo para introducir los datos
      l.setBounds(50,100,200,20); 
      add(l);
      
      b = new JButton(" C a  K"); //boton 1
      b.setBounds(50,150,100,40);
      b.addActionListener(this);
      add(b);

      
      b2 = new JButton(" K a  C"); //boton 2
      b2.setBounds(150,150,100,40);
      b2.addActionListener(this);
      add(b2);
      
      result = new JLabel("_________________________");//etiqueta de resultado
      result.setBounds(350,100,200,20);
      add(result);
      
      a = new JLabel("El resultado de la conversion es:");
      a.setBounds(350, 85, 200, 20);
      add(a);
}
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== b){
        double temperatura = Double.parseDouble(l.getText());
        double k = temperatura + 273.15;
        result.setText(k+"K");
        }
        if(e.getSource() == b2){
            double temperatura = Double.parseDouble(l.getText());
            double c = temperatura - 273.15;
            result.setText(c+"C");
        }

       
    }
        public static void main(String[] args) {
        Temperatura v = new Temperatura();
        v.setVisible(true);
        v.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
