/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numcomplejo;
import java.util.Scanner;
/**
 *
 * @author edgar
 */
public class Numcomplejo {
float real, imaginario;

public Numcomplejo(float real, float imaginario){
    this.real=real;
    this.imaginario=imaginario;
}

Numcomplejo suma(Numcomplejo x){
    return new Numcomplejo(real+x.real,imaginario+x.imaginario);
}
Numcomplejo resta(Numcomplejo x){
    return new Numcomplejo(real-x.real,imaginario-x.imaginario);
}
Numcomplejo multi(Numcomplejo x){
    return new Numcomplejo((real*x.real-imaginario*x.imaginario),(real * x.imaginario+ imaginario*x.real));
}
Numcomplejo div(Numcomplejo x){
 return new Numcomplejo(((real*x.real)+(imaginario*x.imaginario))/((x.real*x.real)+(x.imaginario*x.imaginario)),((imaginario*x.real)-(real*x.imaginario))/((x.real*x.real)+(x.imaginario*x.imaginario)));   

}
 boolean esigual(Numcomplejo x){
    return real+imaginario == x.real+x.imaginario;
}
double modulo(Numcomplejo x){
    double k = x.real*x.real;
    double t = x.imaginario*x.imaginario;
    return Math.sqrt(k+t);
}
void imprime(){
    System.out.println(this.real+"+"+this.imaginario+"i");
}


    public static void main(String[] args) {
        int a,b,c,d;
        boolean p;
        Numcomplejo q,w,e;
        byte opc;
        Scanner entrada= new Scanner(System.in);
        
        
        System.out.println("Números complejos");
        System.out.println("1: Sumar");
        System.out.println("2: Restar");
        System.out.println("3: Multiplicar");
        System.out.println("4: Dividir");
        System.out.println("5: Modulo");
        System.out.println("6: Es igual");
        System.out.println("Seleccione una opción:");
        opc =entrada.nextByte();
        

          
        switch(opc){
            case 1:
          System.out.println("Ingresa la parte real del complejo 1:");
          a = entrada.nextInt();
          System.out.println("Ingresa la parte imaginaria del complejo 1:");
          b = entrada.nextInt();
          System.out.println("Ingresa la parte real del complejo 2:");
          c = entrada.nextInt();
          System.out.println("Ingresa la parte imaginaria del complejo 2:");
          d = entrada.nextInt();
          
                q = new Numcomplejo(a,b);
                w = new Numcomplejo(c,d);
                e = q.suma(w);
                e.imprime();
                break;
            case 2:
          System.out.println("Ingresa la parte real del complejo 1:");
          a = entrada.nextInt();
          System.out.println("Ingresa la parte imaginaria del complejo 1:");
          b = entrada.nextInt();
          System.out.println("Ingresa la parte real del complejo 2:");
          c = entrada.nextInt();
          System.out.println("Ingresa la parte imaginaria del complejo 2:");
          d = entrada.nextInt();
          
                q = new Numcomplejo(a,b);
                w = new Numcomplejo(c,d);
                e = q.resta(w);
                e.imprime();
                break;
            case 3:
          System.out.println("Ingresa la parte real del complejo 1:");
          a = entrada.nextInt();
          System.out.println("Ingresa la parte imaginaria del complejo 1:");
          b = entrada.nextInt();
          System.out.println("Ingresa la parte real del complejo 2:");
          c = entrada.nextInt();
          System.out.println("Ingresa la parte imaginaria del complejo 2:");
          d = entrada.nextInt();
          
                q = new Numcomplejo(a,b);
                w = new Numcomplejo(c,d);
                e = q.multi(w);
                e.imprime();
                break;
            case 4:
          System.out.println("Ingresa la parte real del complejo 1:");
          a = entrada.nextInt();
          System.out.println("Ingresa la parte imaginaria del complejo 1:");
          b = entrada.nextInt();
          System.out.println("Ingresa la parte real del complejo 2:");
          c = entrada.nextInt();
          System.out.println("Ingresa la parte imaginaria del complejo 2:");
          d = entrada.nextInt();
          
                q = new Numcomplejo(a,b);
                w = new Numcomplejo(c,d);
                e = q.div(w);
                e.imprime();
                break;
            case 5:
          System.out.println("Ingresa la parte real del complejo 1:");
          a = entrada.nextInt();
          System.out.println("Ingresa la parte imaginaria del complejo 1:");
          b = entrada.nextInt();
          
                q = new Numcomplejo(a,b);
                q.modulo(q);
                System.out.println(q.modulo(q));
                break;
            case 6:
          System.out.println("Ingresa la parte real del complejo 1:");
          a = entrada.nextInt();
          System.out.println("Ingresa la parte imaginaria del complejo 1:");
          b = entrada.nextInt();
          System.out.println("Ingresa la parte real del complejo 2:");
          c = entrada.nextInt();
          System.out.println("Ingresa la parte imaginaria del complejo 2:");
          d = entrada.nextInt();
                q = new Numcomplejo(a,b);
                w = new Numcomplejo(c,d);
                p = q.esigual(w);
                if(p==true)System.out.println("Complejo 1 = Complejo 2");
                else System.out.println("Complejo 1 != Complejo 2");
                break;
        }
        
    }
    
}
