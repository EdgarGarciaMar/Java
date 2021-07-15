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
    if(front==0 && rear==0){
        System.out.println("La cola esta vacia.");
    }
    else{
    System.out.println("Se elimino el dato:"+Elementos[front]);
    Elementos[front]=0;
    front++;
    }
}

public void display(){
    if(front==0 && rear==0){
        System.out.println("La cola esta vacia.");
    }
    else{
    if(front==0 && rear==1){
        System.out.println("\tFront y Rear");
        System.out.println("\t|");
        System.out.println("\tv");
        for(int i=front;i<rear;i++){
        System.out.print("\t"+Elementos[i]);
        System.out.println("");
        
    }
    }
    else{
    for(int i=front;i<rear;i++){
        System.out.print("\t"+Elementos[i]);
        if(front==i){
            System.out.print("");
            System.out.print("Front");
        }
        else if(rear==i+1){
            System.out.print("");
            System.out.print("Rear");
        }
        System.out.println("");
        
    }
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
