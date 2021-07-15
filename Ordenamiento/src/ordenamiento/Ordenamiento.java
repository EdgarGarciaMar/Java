/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

import java.util.Scanner;

/**
 *
 * @author edgargarcia
 */
public class Ordenamiento {
private int array[];
private Scanner entrada= new Scanner(System.in);

public Ordenamiento(int n){
    this.array=new int[n];
}

public void display(int tam){
    System.out.println("Los datos ordenados son:");
    for(int i=0;i<tam;i++){
        System.out.println("["+i+"]"+array[i]);
    }
}
//Los metodos de ordenamiento requieren las posiciones del arreglo y el arreglo.
public void quicksort(int primero, int ultimo){
    int i,j,aux,piv;
    i=primero;
    j=ultimo;
    piv=array[(primero+ultimo)/2];
    do{
        while(array[i]<piv){
            i++;
        }
        while(array[j]>piv){
            j--;
        }
        //intercambio
        if(i<=j){
            aux=array[i];
            array[i]=array[j];
            array[j]=aux;
            i++;
            j--;        
        }
    }while(i<=j);
    if(primero<j){
        quicksort( primero, j);
    }
    if(i<ultimo){
        quicksort( i, ultimo);
    }
}

public void burbuja(int tam){
    int pasadas=0;
    int i;
    int j;
    int aux;
    for(i=1;i<tam;i++){
        for(j=0;j<tam-1;j++){
            if(array[j]>array[j+1]){
                aux=array[j];
                array[j]=array[j+1];
                array[j+1]=aux;
            }
            pasadas++;
        }
    }
    System.out.println("Se ordeno en "+pasadas+" pasadas");
}

public void scanear(int tam){
    int dato;
    for(int i=0;i<tam;i++){
        dato=entrada.nextByte();
        array[i]=dato;
    }
}

    public static void main(String[] args) {
        int tam;
        Ordenamiento arreglo;
        Scanner entrada= new Scanner(System.in);
        int opc;
        int salida=1;
        System.out.println("---Ordenamientos de datos---");
        System.out.println("Ingrese el tamaño del arreglo:");
        tam=entrada.nextByte();
        arreglo=new Ordenamiento(tam);
        System.out.println("Ingrese los datos a ser ordenados:");
        arreglo.scanear(tam);
        
        while(salida==1){
        System.out.println("---Opciones---");
        System.out.println("1: Quicksort");
        System.out.println("2: Burbuja");
        System.out.println("9: Salir");
        System.out.println("Selecciona una opción:");
        opc=entrada.nextByte();
        
        switch(opc){
            case 1:
                arreglo.quicksort( 0, tam-1);
                arreglo.display(tam);
                break;
            case 2:
                arreglo.burbuja(tam);
                arreglo.display(tam);
                break;
            case 9:
                salida=0;
                break;
            default:
                System.out.println("***Seleccione una opción del menu***");
                break;
        }
        }
    }
    
}
