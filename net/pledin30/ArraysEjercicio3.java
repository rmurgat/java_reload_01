package net.pledin30;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;


public class ArraysEjercicio3 {
    private int numbers[] = {52,3,2,1,9,99,2,3,5,99,25,24,38,59,98,12,34,46,58,69,75,43,24,56,15,90,55,49,69,77,88,11};

    private class Student {
        public int id;
        public String name;
        public int rate;
    }

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

    /*
     * Ejercicio 4Permalink
     *  Programa que declare un vector de cien elementos enteros y pida números para rellenarlo hasta que 
     *  se llene el vector o se introduzca un número negativo. Entonces se debe imprimir el vector (sólo los elementos introducidos).
     */
    public void showInputNumberUntilNegative() {
        int[] vector = new int[100];
        int counter=0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter positive values and use negative to stop");
        while(counter<100) {
            int num = Integer.parseInt(scan.nextLine());
            if(num<0) break;
            vector[counter++] = num;
        }
        int[] vector1 = new int[counter];
        System.out.println("Printing array (sorted)");
        vector1 = Arrays.copyOf(vector,counter);
        Arrays.sort(vector1);
        for(int i=0; i<counter; i++) {
            System.out.printf("%d,",vector1[i]);
        }
        scan.close();
    }

    /* Ejercicio 5:
        Hacer un programa que inicialice un vector de números con valores aleatorios, y posterior ordene los elementos de menor a mayor. 
    */
    public void showAletarotyNumbersAndSort() {
        int[] vector = new int[100];
        Random rand = new Random();
        for(int i=0; i<100; i++) {
            vector[i]= rand.nextInt(1000);
        }
        Arrays.sort(vector);
        System.out.println("Printing random numbers and sorted:");
        for(int i=0; i<100; i++) {
            System.out.printf("%d, ", vector[i]);
        }
        System.out.println();
    }

    public void showMonthNameAndDays() {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] months = {"January","Febrary","March","April","May","June","July","August","September","October","November","December"};
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the Mounth number:");
        int monthid = scan.nextInt();
        scan.close();
        if(monthid<1 || monthid>12) {
            System.out.println("It is just using Earth Calendar");
            return;
        }
        System.out.printf("%d day in %s month", days[monthid-1], months[monthid-1]);
    }

    public void showSumVectors() {
        int[] vector1 = new int[5];
        int[] vector2 = new int[5];
        int[] vector3 = new int[5];
        Scanner scan = new Scanner(System.in);

        System.out.println("Sum vector3 = vector1+vector2");
        System.out.println("Enter values");
        for(int i=0; i<5; i++) {
            System.out.printf("Enter values to position [%d] ",(i+1));
            System.out.printf("Vector 1? position %d:", (i+1));
            vector1[i]=scan.nextInt();
            System.out.printf("Vector 2? position %d:", (i+1));
            vector2[i]=scan.nextInt();
            vector3[i]=vector1[i]+vector2[i];
        }
        System.out.println("Printing vector 3");
        for(int i=0; i<5; i++) {
            System.out.printf("vector3[%d] = %d:",(i+1), vector3[i]);
        }
        scan.close();
    }

    /**Ejercicio 3:
     * Se quiere realizar un programa que lea por teclado las 5 notas obtenidas por un alumno (comprendidas entre 0 y 10). 
     * A continuación debe mostrar todas las notas, la nota media, la nota más alta que ha sacado y la menor.
    */
    public void showAskStudentRate() {
        Student[] students = new Student[10];
        int maxrate = 0;
        int sum=0;
        int i;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter Students properties and finish with * as name");
        for(i=0; i<10; i++) {
            students[i] = new Student();
            students[i].id = i+1;
            System.out.printf("Enter name to Student %d: ",(i+1));
            students[i].name=scan.nextLine();
            if(students[i].name.startsWith("*")) break;
            System.out.printf("Enter rate to Studden %d: ",(i+1));
            students[i].rate=Integer.parseInt(scan.nextLine());
            maxrate = Math.max(students[i].rate,maxrate);
            sum+=students[i].rate;

        }
        scan.close();
        double media = (double)sum/(i);
        System.out.printf("Media rate: %.2f \n",media);
        System.out.printf("Max rate: %d \n",maxrate);
        for(int j=0; j<i; j++) {
            Student s = students[j];
            System.out.printf("Student %d: ",(j+1));
            System.out.printf("name: %s, rate:%d \n", s.name,s.rate);
        }

    }

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArraysEjercicio3 app = new ArraysEjercicio3();
        System.out.println("\n** Menu **");
        System.out.println("1. Calculus 5 Notes");
        System.out.println("2. Max Number in array");
        System.out.println("3. Convert Array Number to String");
        System.out.println("4. Input numbers until negative");
        System.out.println("5. Creating aleatory numbers at vector and sort");
        System.out.println("6. Get Month days");
        System.out.println("7. Get vector3=Sum(vector1,vector2)");
        System.out.println("8. Enter students names & rates");
        System.out.println("99. Exit");
        System.out.println("Select one option...");
        int opt = scan.nextInt();
        switch (opt) {
            case 1: 
                app.show5notes();
                break;
            case 2: 
                app.showMaxnumber();
                break;
            case 3: 
                app.showConversionANumber2String();
                break;
            case 4: 
                app.showInputNumberUntilNegative();
                break;
            case 5:
                app.showAletarotyNumbersAndSort();
                break;
            case 6:
                app.showMonthNameAndDays();
                break;
            case 7:
                app.showSumVectors();
                break;
            case 8:
                app.showAskStudentRate();
                break;
            case 99: 
                break;
            default:
                System.out.println("Option not recognized");
        }
        System.out.println();
    }
}
