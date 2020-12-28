/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentasegundos;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author edgar
 */
public class CuentaSegundos extends JFrame implements Runnable {
 JLabel l;
 Thread hilo;
 int segundos;
 int limite;
 int sleep1;
 
   public CuentaSegundos(int seg,int sleep){
        super("Cuenta Segundos");
        this.setSize(400,200); 
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        l = new JLabel("----------");
        l.setBounds(200, 50, 100, 50);
        this.add(l);
        segundos=0;
        limite=seg;
        sleep1=sleep;
        hilo=new Thread(this); //debe ser de las ultimas lin. del constructor
        hilo.start(); //debe ser de las ultimas lineas del constructor
   }
    @Override
    public void run() {
        
        for(int i=0;i<=limite;i++){
            
            String numCadena= String.valueOf(segundos);
            l.setText(numCadena);
            segundos ++;
        try{
            Thread.sleep(sleep1);
        }
        catch(Exception e){
              return;
        }
       
        }
    }
    
        public static void main(String[] args) {
        new CuentaSegundos(60,500);
    }
    
}
