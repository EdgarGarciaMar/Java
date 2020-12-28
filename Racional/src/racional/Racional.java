/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racional;
import java.util.Scanner;
/**
 *
 * @author edgar
 */
public class Racional {
int den, num;

	public Racional(int num, int den){
		this.den=den; 
		this.num=num;
	}
	Racional mult(Racional r){
		return new Racional(num * r.num, den * r.den);
	}
	Racional division(Racional r){
		return new Racional(num * r.den, den * r.num);
	}
        Racional suma(Racional r){
            return new Racional((num * r.den)+(den * r.num), den * r.den);
        }
        
        Racional resta(Racional r){
            return new Racional((num * r.den)-(den * r.num), den * r.den);
        }
        
	boolean esIgual(Racional r){
		return num * r.den == den * r.num;
	}
        
	void imprime(){
		System.out.println(this.num+" / "+ this.den);
	}
       
      public static void main(String[] args) {
         int opc;
         int a,b,c,d;
         boolean r4;
         Scanner entrada= new Scanner(System.in);
         Racional r1, r2, r3;

          System.out.println("Racional");
          System.out.println("1: Sumar");
          System.out.println("2: Restar");
          System.out.println("3: Multiplicar");
          System.out.println("4: Dividir");
          System.out.println("5: Es igual");
          System.out.println("Seleccione una opción para realizar una operación:");
          opc = entrada.nextByte();
          
          
          System.out.println("Ingresa el numerador del racional 1:");
          a = entrada.nextInt();
          System.out.println("Ingresa el denominador del racional 1:");
          b = entrada.nextInt();
          System.out.println("Ingresa el numerador del racional 2:");
          c = entrada.nextInt();
          System.out.println("Ingresa el denominador del racional 2:");
          d = entrada.nextInt();
          
         
          switch(opc){
              case 1:
              r1=new Racional(a,b);
              r2=new Racional(c,d);
              r3=r1.suma(r2);
              r3.imprime();
              break;
              case 2:
              r1=new Racional(a,b);
              r2=new Racional(c,d);
              r3=r1.resta(r2);
              r3.imprime();
              break;
              case 3:
              r1=new Racional(a,b);
              r2=new Racional(c,d);
              r3=r1.mult(r2);
              r3.imprime();
              break;
              case 4:
              r1=new Racional(a,b);
              r2=new Racional(c,d);
              r3=r1.division(r2);
              r3.imprime();
              break;
              case 5:
              r1=new Racional(a,b);
              r2=new Racional(c,d);
              r4=r1.esIgual(r2);
              if(r4==true)System.out.println("Racional 1 = Racional 2.");
              else System.out.println("Racional 1 != Racional 2.");
              break;
          }
    }
}
