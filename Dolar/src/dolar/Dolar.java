/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dolar;

import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class Dolar extends JFrame implements ActionListener{
private JButton b1,b2;
private JTextField a1,a2;
private JLabel m;

public Dolar(){
        super("Divisas");
        this.setSize(1000,100); 
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1, 5,4,4));
        b1 = new JButton("Pesos a Dolar");
        b2 = new JButton("Dolar a Pesos");
        a1 = new JTextField(25);
        a2 = new JTextField(25);
        m = new JLabel("------");
        this.add(a1);
        this.add(b1);
        this.add(b2);
        this.add(a2);
        this.add(m);
        b1.addActionListener(this);
        b2.addActionListener(this);
        
}

    @Override
    public void actionPerformed(ActionEvent e) {
        double monto= Double.parseDouble(a1.getText());
        double factor= Double.parseDouble(a2.getText()); 
        if(e.getSource()== b1){
            double montodolar= monto/factor;
            m.setText("$"+montodolar+"Dolares");
        }
        else if(e.getSource()==b2){
            double montopeso= monto*factor;
            m.setText("$"+montopeso+"Pesos");
        }
    }
    

        public static void main(String[] args) {
        new Dolar();
    }
}
