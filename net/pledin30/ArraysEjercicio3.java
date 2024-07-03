package net.pledin30;

import java.util.Arrays;
import java.util.Scanner;

/**Ejercicio 3Permalink
 * Se quiere realizar un programa que lea por teclado las 5 notas obtenidas por un alumno (comprendidas entre 0 y 10). A continuación debe mostrar todas las notas, la nota media, la nota más alta que ha sacado y la menor.
 */

public class ArraysEjercicio3 {
    private int numbers[] = {52,3,2,1,9,99,2,3,5,99,25,24,38,59,98,12,34,46,58,69,75,43,24,56,15,90,55,49,69,77,88,11};

    public void show5notes() {
        Scanner scan = new Scanner(System.in);
        int notes[] = new int[5];
        int sum=0, min=10, max=0; 

        System.out.println("Enter 5 notes about student:");
        for(int i=0; i<5; i++) {
            System.out.printf("Note [%d]",(i+1));
            notes[i]=scan.nextInt();
            sum+=notes[i];
            min=Math.min(min,notes[i]);
            max=Math.max(max,notes[i]);
        }
        System.out.printf("median=%f, min=%d, max=%d", (double)sum/5, min, max);
    }

    public void showMaxnumber() {
        int sum=0, min=0, max=0; 
        System.out.println("Gived one array choosing max, min value:");
        min = numbers[0];
        for(int i=0; i<numbers.length; i++) {
            sum+=numbers[i];
            min = Math.min(min,numbers[i]);
            max = Math.max(max,numbers[i]);
        }
        System.out.printf("median=%f, min=%d, max=%d\n", (double)sum/numbers.length, min, max);
        System.out.println("Array sorted:");
        Arrays.sort(numbers);
        for(int i=0; i<numbers.length; i++) {
            System.out.printf("%d,",numbers[i]);
        }
    }

    public void showConversionANumber2String() {
        String res="";
        for(int i=0; i<numbers.length; i++) {
            res += String.valueOf(numbers[i]) + "-";
        }        
        System.out.println(res);
    }

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArraysEjercicio3 app = new ArraysEjercicio3();
        System.out.println("\n** Menu **");
        System.out.println("1. Calculus 5 Notes");
        System.out.println("2. Max Number in array");
        System.out.println("3. Convert Array Number to String");
        System.out.println("Select one option...");
        int opt = scan.nextInt();
        switch (opt) {
            case 1: app.show5notes();
            break;
            case 2: app.showMaxnumber();
            break;
            case 3: app.showConversionANumber2String();
            break;
            default:
                System.out.println("Option not recognized");
        }
        System.out.println();
    }
}
