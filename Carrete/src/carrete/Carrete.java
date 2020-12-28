/*
1.-Modelar un Carrete (o rollo) de tela

-suponga que cada carrete viene con 200 m de tela

-la tela solo se vende al menudeo por metro (o sea no por carrete)

-Si hay suficiente tela entonces se debe cortar del carrete la cantidad de tela que pida el cliente
Diagrama UML:
===============================
            Carrete
===============================
- LongitudCarrete de tipo float
--------------------------------
+ Ventacarrete(): Float
+ imprimelongitud(): void

 */
package carrete;
import java.util.Scanner;

public class Carrete {
    private float LongitudCarrete ;
    
    public Carrete( ){
        this.LongitudCarrete = 200;
    }
    
    public float Ventacarrete(Carrete x,float a){
        if(a > x.LongitudCarrete){
            System.out.println("No hay suficiente tela.");
            return x.LongitudCarrete;
        }
        else{
            return x.LongitudCarrete-a;
        }
    }
    
    public void imprimelongitud(float b){
        if(b==0)System.out.println("La longitud del carrete es:"+LongitudCarrete+" metros");
        else System.out.println("La longitud restante del carrete es: "+b+" metros.");
    }
    
    public static void main(String[] args) {
        Carrete c1;
        int opc;
        Scanner entrada= new Scanner(System.in);
        
        System.out.println("Sedería");
        System.out.println("1: Venta de carrete color verde por metro");
        System.out.println("2: Consultar los metros disponibles del carrete");
        System.out.println("Seleccione una opción:");
        opc = entrada.nextByte();
        
        switch(opc){
            case 1:
                System.out.println("Ingresa la longitud que desea comprar: ");
                float a =entrada.nextFloat();
                c1 = new Carrete();
                float b =c1.Ventacarrete(c1, a);
                c1.imprimelongitud(b);
                break;
            case 2:
                c1 = new Carrete();
                c1.imprimelongitud(0);
                break;
              
        }
    }
    
}
