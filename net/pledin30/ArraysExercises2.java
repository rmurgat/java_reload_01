package net.pledin30;

import java.util.Scanner;

/**
 * Ejercicio 2:
 * Crear un vector de 5 elementos de cadenas de caracteres, inicializa el vector con datos leídos por el teclado. Copia los elementos del vector en otro vector pero en orden inverso, y muéstralo por la pantalla.
 */

public class ArraysExercises2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] cadenas = new String[5]; 
        String[] inverso = new String[5];

        System.out.println("Adding 5 strings:");
        for(int i=0; i<5; i++) {
            System.out.printf("[%d:] ", (i+1));
            cadenas[i]=scan.nextLine();
        }
        for(int i=0, j=4; i<5; i++,j--) {
            inverso[j]=cadenas[i];
        }

        System.out.println("Printing inverted array:");
        for(int i=0; i<5; i++) {
            System.out.println(inverso[i]);
        }
    }
    
}
