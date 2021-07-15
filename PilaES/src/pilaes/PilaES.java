/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilaes;

import static java.lang.Boolean.TRUE;
import java.util.Scanner;

/**
 *
 * @author edgargarcia
 */
public class PilaES {
private int Elementos[];
private int Tope= 0;



public PilaES (int datos){
    this.Elementos=new int[datos]; 
    this.Tope=0;
    
}

public void imprimir(int tam){
if(Tope==tam){
System.out.println("        <-- tope");
}
for(int i=tam-1;i>=0;i--){
System.out.print("["+i+"]"+" "+Elementos[i]);
if(i==Tope){
    System.out.print("        <-- tope");
}
    System.out.println("");
}
}

public int pop(){
    Tope--;
    return Elementos[Tope];
}
public void push(int dato){
    Elementos[Tope]=dato;
    Tope++;
}
public boolean estaVacia(){
    return Tope==0;
}
public int top(){
    return Elementos[Tope-1];
}
    public static void main(String[] args) {
        
    PilaES pila;
    int opc;
    Scanner entrada= new Scanner(System.in);
    int tam;
    int dato;
    int salida=0;
    
    System.out.println("---Pila Estatica---");
    System.out.println("Ingrese el tamaño de la pila:");
    tam=entrada.nextByte();
    pila=new PilaES(tam);
    
    while(salida==0){
    System.out.println("---Opciones de la Pila---");
    System.out.println("1: Agregar un elemento a la pila");
    System.out.println("2: Sacar elemento de la pila");
    System.out.println("3: Consultar los elementos de la pila");
    System.out.println("4: Consultar si la pila esta vacia");
    System.out.println("5: Consultar el tope de la pila");
    System.out.println("6: Salir");
     
    System.out.println("Selecciona una de las opciones:");
    opc=entrada.nextByte();

    
    switch(opc){
        case 1:
        System.out.println("Ingrese el dato");
        dato=entrada.nextByte();
        pila.push(dato);
        break;
        case 2:
        pila.pop();
        break;
        case 3:
        pila.imprimir(tam);
        break;
        case 4:
        Boolean p = pila.estaVacia();
        if(p==TRUE){
        System.out.println("La pila esta vacia");
        }
        else{
        System.out.println("La pila no esta vacia");
        }
        break;
        case 5:
        int Dat=pila.top();
        System.out.println("El tope es:"+Dat);
        break;
        case 6: 
        salida=1;
        break;
        default:
        System.out.println("***Seleccione una opción***");
        break;
    }
    }
    }
}
