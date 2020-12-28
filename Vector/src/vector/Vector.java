/*
2.-Codificar en Java un tipo de dato abstracto (TAD) para vectores bidimensionales Vec2D

Si v1 = (x1, y1) y v2 = (x2, y2)

entonces:

suma v1+v2=(x1+x2, y1+y2)

resta v1-v2=(x1-x2, y1-y2)

producto punto v1.v2= x1*x2 + y1*y2 resultado escalar

Si v = (x, y) entonces modulo(v) = sqrt(x*x + y*y) = sqrt (productoPunto(x, y))

v1 = v2 si x1=x2 y y1=y2

Codificar el constructor
Este TAD debe tener las siguientes operaciones: sumar, restar, productoPunto, modulo, esIgual, imprimir

Diagrama UML:
=======================================
                 vector
=======================================
    - Coordenada en x de tipo float
    - Coordenada en y de tipo float
---------------------------------------
    + suma(): Vector
    + resta(): Vector
    + ppunto(): float
    + modulo(): double
    + esigual(): True o False
    + imprimir(): Void
*/
package vector;

import java.util.Scanner;

public class Vector {
    private float x, y;// preguntar sobre el private del uml
    public Vector(float x, float y){
    this.x = x;
    this.y = y;
    }
    
    public Vector suma(Vector c){
        return  new Vector(x+c.x,y+c.y);
    }
    public Vector resta (Vector c){
        return new Vector(x-c.x,y-c.y);
    }
    public float ppunto(Vector c){
        return((x*c.x)+(y*c.y));
    }
    public double modulo(Vector c){
        return Math.sqrt((c.x*c.x)+(c.y*c.y));
    }
    public boolean esigual(Vector c){
        if(x == c.x && y == c.y){
            return true;
        }
        else {
            return false;
        }
    }
    public void imprimir(Vector c){
        System.out.println("El resultado es:"+c.x+"+"+c.y);
    }

    public static void main(String[] args) {
        Vector v1,v2,v3;
        float x,y,z,k;
        int opc;
        Scanner entrada= new Scanner(System.in);
        
        System.out.println("vectores bidimensionales");
        System.out.println("1: Sumar");
        System.out.println("2: Restar");
        System.out.println("3: Producto punto");
        System.out.println("4: Modulo");
        System.out.println("5: Es igual");
        System.out.println("Selecciona una opción:");
        opc =entrada.nextByte();
        
       switch(opc){
           case 1:
               System.out.println("Ingresa el valor de x1:");
               x = entrada.nextFloat();
               System.out.println("Ingresa el valor de y1:");
               y = entrada.nextFloat();
               System.out.println("Ingresa el valor de x2:");
               z = entrada.nextFloat();
               System.out.println("Ingresa el valor de y2:");
               k = entrada.nextFloat();
               
               v1 = new Vector(x,y);
               v2 = new Vector(z,k);
               v3 = v1.suma(v2);
               v3.imprimir(v3);
               break;
           case 2:
               System.out.println("Ingresa el valor de x1:");
               x = entrada.nextFloat();
               System.out.println("Ingresa el valor de y1:");
               y = entrada.nextFloat();
               System.out.println("Ingresa el valor de x2:");
               z = entrada.nextFloat();
               System.out.println("Ingresa el valor de y2:");
               k = entrada.nextFloat();
               
               v1 = new Vector(x,y);
               v2 = new Vector(z,k);
               v3 = v1.resta(v2);
               v3.imprimir(v3);
               break;
           case 3:
               System.out.println("Ingresa el valor de x1:");
               x = entrada.nextFloat();
               System.out.println("Ingresa el valor de y1:");
               y = entrada.nextFloat();
               System.out.println("Ingresa el valor de x2:");
               z = entrada.nextFloat();
               System.out.println("Ingresa el valor de y2:");
               k = entrada.nextFloat();
               
               v1 = new Vector(x,y);
               v2 = new Vector(z,k);
               float a = v1.ppunto(v2);
               System.out.println("El resultado es: "+a);
               break;
           case 4:
               System.out.println("Ingresa el valor de x1:");
               x = entrada.nextFloat();
               System.out.println("Ingresa el valor de y1:");
               y = entrada.nextFloat();
               
               v1 = new Vector(x,y);
               double b = v1.modulo(v1);
               System.out.println("El resultado es: "+b);
               break;
           case 5:
               System.out.println("Ingresa el valor de x1:");
               x = entrada.nextFloat();
               System.out.println("Ingresa el valor de y1:");
               y = entrada.nextFloat();
               System.out.println("Ingresa el valor de x2:");
               z = entrada.nextFloat();
               System.out.println("Ingresa el valor de y2:");
               k = entrada.nextFloat();
               
               v1 = new Vector(x,y);
               v2 = new Vector(z,k);
               boolean p = v1.esigual(v2);
               if(p==true){
                   System.out.println("Vector 1 = Vector 2");
               }
               else{
                   System.out.println("Vector 1 != Vector 2");
               }
               break;
       }
    }
    
}
