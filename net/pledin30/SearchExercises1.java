package net.pledin30;

import java.util.Arrays;
import java.util.Scanner;
import net.util.HiUtilery;

/*
 * Ejercicios sobre búsqueda secuencial
 * channel: https://www.youtube.com/@ProgramaTutos/videos
 * video: https://www.youtube.com/watch?v=7Uf6ceQGj2I
 */
public class SearchEjercicio4 {
    private HiUtilery outil = new HiUtilery();

    public void searchingSequential() {
        int[] values = new int[100];
        Scanner sn = new Scanner(System.in);
        for(int i=0; i<values.length; i++) {
            values[i]=outil.generateRandom(1, 1000);
        }
        System.out.println("SECUENCIAL SEARCH");
        System.out.println("values: " + Arrays.toString(values));
        int value2search = sn.nextInt();
        boolean blocated = false;
        for(int i=0; i<values.length; i++) {
            if(value2search==values[i]) {
                System.out.printf("I FOUND in %d position",i+1);
                blocated=true;
            }
        }
        if(!blocated) {
            System.out.println("VALUE was not located");
        }
    }

    public void searchingInBinaryWay() {
        Scanner sn = new Scanner(System.in);
        int[] values = new int[1000];
        for(int i=0; i<1000; i++) {
            values[i] = i * 2;
        }
        System.out.println("BINARY SEARCH IN ORDERED ARRAY");
        System.out.println("values:"+Arrays.toString(values));
        System.out.println("Type number to lookup:");
        int lookup = sn.nextInt();
        int start = 0;
        int end = values.length-1;
        int middle = 0;

        while(start <= end) {
            middle = (start + end) / 2;
            if(lookup == values[middle]) {
                System.out.printf("Value looked up in position %d", middle);
                break;
            } else if(lookup < values[middle]) {
                end = middle - 1;
            } else {
                start = middle +1;
            }
        }

        // result confirmation 
        System.out.println("Arrays Binary Search result: " + Arrays.binarySearch(values, lookup));
        sn.close();
    }


    public static void main(String[] args) {
        int option=0;
        SearchEjercicio4 app = new SearchEjercicio4();
        Scanner sn = new Scanner(System.in);
        System.out.println("--[MAIN MENU]--");
        System.out.println("1. Secuential search");
        System.out.println("2. Binary search");
        option = sn.nextInt();
        switch (option) {
            case 1:
                app.searchingSequential();
                break;
            case 2:
                app.searchingInBinaryWay();
                break;
        
            default:
                System.out.println("OPTION IS NOT CORRECT");
                break;
        }
        sn.close();
    }

}
