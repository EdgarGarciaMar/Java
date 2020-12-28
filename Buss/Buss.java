/*
García Marciano Edgar
Practica N°2
Arreglos de objetos
Opción N° 2 Reservaciones de asientos en el camión
12/11/2020
2CM3
Programación Orientada a Objetos
Tecla Parra Roberto
 */


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author edgar
 */
public class Buss extends JFrame implements ActionListener {
    
 private JPanel superior,inferior;
 private JButton botones[]=new JButton[44];
 private JButton boton2,q;
 private JLabel disponibilidad,m,r,reservados,k;
 
 public short contador = 0;
 public String asiento[] = new String[44];
 public String resultado = "";
 
     public Buss(){
        super("POO BUSS. Venta de boletos.");
        ventanasuperior();
        ventanainferior();
        ventana();
    }
     
public void ventanasuperior(){
    superior = new JPanel();
    superior.setLayout(null);
    m = new JLabel("Seleccione el asiento que sera ocupado por un pasajero.");//instrucciones
    m.setBounds(0,0, 400, 20);
    superior.add(m);
    r = new JLabel("Se reservo el asiento numero: ");
    r.setBounds(0,90, 180, 20);
    superior.add(r);
    disponibilidad=new JLabel("------------");
    disponibilidad.setBounds(184,90,60,20);
    superior.add(disponibilidad);
    reservados = new JLabel("Los asientos reservados son:");
    reservados.setBounds(400,90,180,20);
    superior.add(reservados);
    k=new JLabel("------------");
    k.setBounds(400,95,1000,100);
    superior.add(k);
    q = new JButton("Reinicio");
    q.setBounds(0, 200, 90, 20);
    q.addActionListener(this);
    superior.add(q);
}
public void ventanainferior(){
    inferior = new JPanel();
    inferior.setLayout(new GridLayout(4,11,2,2));
        for(int i=0; i<44; i++){
            inferior.add(botones[i]=new JButton(""+i));
            botones[i].addActionListener(this);  
        }
        inferior.add(boton2 = new JButton("Consulta"));
        boton2.addActionListener(this);
        
}
public void ventana(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 500); 
        this.setVisible(true);
        this.setLayout(new GridLayout(2,1));
        this.add(superior);
        this.add(inferior);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton btn=(JButton)e.getSource();
        if(btn == q){
            this.dispose();
            new Buss();
        }
        
        if(btn== boton2){
        btn.setBackground(java.awt.Color.green);
        for(int i = 0; i<contador;i++){
            resultado+= asiento[i];
            resultado+=",";
        }
        k.setText(""+resultado);
        if(contador == 44){
        JOptionPane.showMessageDialog(null,"Todos los asientos estan ocupados.");
        }
        }
        else{
        asiento[contador] =btn.getText().toString();
        contador++;
        btn.setText("R");
        btn.setBackground(java.awt.Color.red);
        btn.setEnabled(false);
        for(int i = 0; i<contador;i++){
            disponibilidad.setText(""+asiento[i]);
        }
        
        }
        
    }
        public static void main(String[] args) {
        new Buss();
        
    }

}
