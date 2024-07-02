package net.pledin30;

import java.util.Scanner;
import net.util.HiUtilery;

/**
 * Ejercicio 1:
 * Realizar un programa que defina un vector llamado “vector_numeros” de 10 enteros, a continuación lo inicialice con valores aleatorios (del 1 al 10) y posteriormente muestre en pantalla cada elemento del vector junto con su cuadrado y su cubo.
 * @param args
 */
public class ArraysEjercicio1 {

    public static void main(String[] args) {
        int vector_numeros[] = new int[10];
        Scanner scan = new Scanner(System.in);
        HiUtilery util = new HiUtilery();

        System.out.println("please, add 10 int values");
        for(int i=0; i<10; i++) {
            System.out.printf("Enter number in position %d: ", i);
            vector_numeros[i] = Integer.valueOf(scan.nextLine());
        }

        System.out.println("printing values");
        for(int i=0; i<10; i++) {
            System.out.printf("original: %d - pow(2, %8.2f) - pow(3, %8.2f) ",vector_numeros[i], Math.pow(2,vector_numeros[i]), Math.pow(3,vector_numeros[i]));
            System.out.println();
        }
        System.out.println(util.toString());
        scan.close();
    }
}