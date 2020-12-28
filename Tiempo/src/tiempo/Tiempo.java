/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiempo;

import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;


public class Tiempo extends JFrame implements ActionListener{
    private JButton b;
    private JTextField m;
    private JLabel d,h,mm,dm,hm,i;
    
    public Tiempo(){
        super("Convertidor de minutos.");
        this.setSize(600,600); 
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 4));
        mm = new JLabel("Ingresa los minutos");
        dm = new JLabel("Dias");
        hm = new JLabel("Horas");
        i = new JLabel("Haz clic en el boton");
        m =  new JTextField(25);
        d =  new JLabel("----------");
        h =  new JLabel("----------");
        b = new JButton("Calcular");
        this.add(mm);
        this.add(dm);
        this.add(hm);
        this.add(i);
        this.add(m);
        this.add(d);
        this.add(h);
        this.add(b);
        b.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== b){
            double minutos = Double.parseDouble(m.getText());
            double dias = minutos/1440;
            double horas = minutos/60;
            d.setText("D:"+dias);
            h.setText("Hrs.:"+horas);
        }
    }
    
        public static void main(String[] args) {
        new Tiempo();
    }
}
