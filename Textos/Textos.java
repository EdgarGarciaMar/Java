/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textos;

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
public class Textos extends JFrame implements ActionListener, Runnable {
    Thread hilo;
    JTextField c;
    JLabel l;
    JButton b,b2;
    String [] cadenas = new String[3];
    int sleep1;
    int contador = 0;
    int count;
    int max;
    
    public Textos(int sleep,int count1){
        super("Textos");
        this.setSize(400,200); 
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1,3));
        l = new JLabel("----------");
        this.add(l);
        c = new JTextField();
        this.add(c);
        b = new JButton("Guardar");
        this.add(b);
        b.addActionListener(this);
        sleep1=sleep;
        count=count1;
        hilo=new Thread(this); //debe ser de las ultimas lin. del constructor
        hilo.start(); //debe ser de las ultimas lineas del constructor
    }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()== b){
                if(contador != 3){
                String text = c.getText();
                cadenas[contador]=text;
                contador=contador+1;
                c.setText("");
                }
                else{
                    System.out.println("arreglo lleno");
                }
            }
    }
         @Override
         public void run() {   
                while(count != 0){
                for(max = 0; max<count; max++){
                    if(cadenas[max]==null){
                        l.setText("----------");
                    }else{
                       l.setText(String.valueOf(cadenas[max])); 
                    }
                    try{
                        Thread.sleep(sleep1);
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }
            }

         }

    public static void main(String[] args) {
        new Textos(500,3);
        
    }
}
