/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author edgar
 */
public class Segundo extends JFrame implements ActionListener {
    private JTextField h,m,s;
    private JLabel s2,hm,mm,sm;
    private JButton b;
    
    public Segundo(){
        super("Calculadora de segundos");
        this.setSize(700, 500); 
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 4,4,4));
        h = new JTextField(25);
        m = new JTextField(25);
        s = new JTextField(25);
        b = new JButton("Calcular");
        hm = new JLabel("Ingresa las HRS");
        mm = new JLabel("Ingresa los MIN");
        sm = new JLabel("Ingresa los SEG");
        s2 = new JLabel("Total de Segundos:");
        this.add(hm);
        this.add(mm);
        this.add(sm);
        this.add(s2);
        this.add(h);
        this.add(m);
        this.add(s);
        this.add(b);
        b.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b){
         int horas = Integer.parseInt(h.getText());
         int minutos = Integer.parseInt(m.getText());
         int segundos = Integer.parseInt(s.getText());
         int t =(3600*horas)+(minutos*60)+segundos;
         s2.setText("Total de Segundos:"+t);
        }
    }
        public static void main(String[] args) {
        new Segundo();
    }
}
