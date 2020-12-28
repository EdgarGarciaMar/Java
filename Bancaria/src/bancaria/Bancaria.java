/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancaria;

import java.util.Scanner;



/**
 *
 * @author edgar
 */

public class Bancaria {
    double saldo;
    int cuenta;
    public Bancaria(double saldo, int cuenta){
        this.saldo = saldo;
        this.cuenta=cuenta;
    }
    
    
    public double deposito (double a){
        saldo = saldo+a;
        return saldo;
    }
    public double retiro(double a){
        if(a<saldo){
          saldo = saldo-a;
          return saldo;
        }
        else{
           System.out.println("Fondos insuficientes");
            return saldo;
        }
    }
    public void consulta(){
        System.out.println("Su saldo actual es : $"+saldo+" N°.Cuenta:"+cuenta);
    }
    public void imp(){
        System.out.println("Saldo: $"+saldo+" Cuenta:"+cuenta);
    }
    
    public static void main(String[] args) {
        
        Bancaria q;
        int opc;
        double v = 1000;
        int c = 5;
        Scanner entrada= new Scanner(System.in);

        System.out.println("BANCO DE POO S.A. de C.V.");
        System.out.println("Bienvenido, seleccione una opción para acceder a un servicio:");
        System.out.println("1: Apertura de cuenta con $1,000.00 MN");
        System.out.println("2: Retirar dinero desde la cuenta");
        System.out.println("3: Depositar dinero a cuenta");
        System.out.println("4: Consulta de saldo");
        System.out.println("Seleccione una opción:");
        opc =entrada.nextByte();
        switch(opc){
                case 1:
                q = new Bancaria(v,c);
                System.out.println("Apertura de cuenta exitosa.");
                q.imp();
                break;
                case 2:
                q = new Bancaria(v,c);
                q.imp();
                System.out.print("Ingrese el moto a retirar: $");
                double retiro = entrada.nextDouble();
                q.retiro(retiro);
                q.imp();
                break;
                case 3: 
                q = new Bancaria(v,c);
                q.imp();
                System.out.print("Ingrese el monto a depositar: $");
                double r = entrada.nextDouble();
                q.deposito(r);
                q.imp();
                break;
                case 4:
                q = new Bancaria(v,c);
                q.consulta();
                break;

        }
    }
    
}