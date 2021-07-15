/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colaes;

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
    if(front==0){
        System.out.println("La cola esta vacia");
    }
    else{
        System.out.println("La Cola no esta vacia");
        System.out.println("El frente es:"+Elementos[front]);
    }
}

    public static void main(String[] args) {
        
    }
    
}
