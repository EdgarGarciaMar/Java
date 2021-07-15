/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colaes;

import java.util.Scanner;

/**
 *
 * @author edgargarcia
 */
public class ColaEs {
private int Elementos[];
private int front;
private int rear;

public ColaEs(int n){
    this.Elementos= new int [n];
    this.front=0;
    this.rear=0;
}

public void enqueve(int tam,int dato){
    if(rear<tam){
     Elementos[rear]=dato;
     rear++;
    }
    else{
        System.out.println("***Cola llena.***");
    }
}

public void dequeuve(){
    if(front==0 && rear==0)System.out.println("La cola esta vacia.");
    System.out.println("Se elimino el dato:"+Elementos[front]);
    Elementos[front]=0;
    front++;
}

public void display(){
    if(front==0 && rear==0)System.out.println("La cola esta vacia.");
    if(front==rear){
        System.out.println("Front y Rear");
        System.out.println("|");
        System.out.println("v");
    }
    for(int i=front;i<rear;i++){
        System.out.print(Elementos[i]);
        if(front==i){
            System.out.println("");
            System.out.print("Front");
        }
        if(rear==i){
            System.out.println("");
            System.out.print("Rear");
        }
        
    }
}

public void front(){
    if(front==0 && rear==0){
        System.out.println("La cola esta vacia");
    }
    else{
        System.out.println("La Cola no esta vacia");
        System.out.println("El frente es:"+Elementos[front]);
    }
}

    public static void main(String[] args) {
        ColaEs cola;
        int tam;
        int salida=1;
        int opc;
        Scanner entrada = new Scanner(System.in);
        System.out.println("---Cola Estatica---");
        System.out.println("Ingresa el Tamaño:");
        tam= entrada.nextByte();
        cola=new ColaEs(tam);
        
        while(salida==1){
        System.out.println("---Opciones de la Cola---");
        System.out.println("1: Agregar dato a la cola");
        System.out.println("2: Eliminar dato de la cola");
        System.out.println("3: Buscar el frente");
        System.out.println("4: Imprimir la cola");
        System.out.println("5: Salir");
        System.out.println("Selecciona una opción:");
        opc=entrada.nextByte();
        
        switch(opc){
            case 1:
                int dato;
                System.out.println("Ingrese el dato");
                dato=entrada.nextByte();
                cola.enqueve(tam, dato);
                break;
            case 2:
                cola.dequeuve();
                System.out.println("Se elimino el dato del frente.");
                break;
            case 3:
                cola.front();
                break;
            case 4:
                cola.display();
                break;
            case 5:
                salida=0;
                break;
            default:
                System.out.println("***Seleccione una opción del menu.***");
                break;
                        
        }
        
        }
    }
    
}
