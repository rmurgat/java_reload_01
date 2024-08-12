package net.pledin30;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import net.util.HiUtilery;

import java.lang.Math;


/**
 * Practices
 * Youtube Channel: https://youtu.be/edKdQcbFzHI?si=nKUii3k-2hvcW8KM
 */
public class ToStartExercises1 {

    public void sayhello() {
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\r\n");
        System.out.println("Introduce un nombre:");
        String nombre = sn.next();
        System.out.printf("¡Hola %s!", nombre);
    }

    public void askPriceWhitoutIva() {
        final double IVA = 1.16;
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        sn.useLocale(Locale.ENGLISH);
        System.out.println("Which is the price without IVA:");
        float price = sn.nextFloat();
        System.out.printf("Last price = %.2f",(price*IVA));
        sn.close();
    }

    public void isDivisibleAndPair() {
        int num1, num2;
      Scanner sn = new Scanner(System.in);
      System.out.println("Show number characteristics:");
      System.out.print("Enter number 1: ");
      num1 = sn.nextInt();
      System.out.print("Enter number 2: ");
      num2 = sn.nextInt();
      if(num1 % num2==0) 
        System.out.println("Number 1 is divisible in Number 2");
      else
        System.out.println("Number 1 is NOT divisible in Number 2");    
      System.out.println("Number 1 is "+(num1 % 2==0?"pair":"odd"));
      System.out.println("Number 2 is "+(num2 % 2==0?"pair":"odd"));
    }

    public void playrandomNumbers() {
        Random ran = new Random();
        int numrandom1 = ran.nextInt(1,1000);
        long numrandom2 = ran.nextLong(1,1000000);
        float numrandom3 = ran.nextFloat(1,1000);
        double numrandom4 = ran.nextDouble(1,1000000000);

        System.out.printf("Mi número entero aleatorio es: %d\n", numrandom1);
        System.out.printf("Mi número entero aleatorio es: %d\n", numrandom2);
        System.out.printf("Mi número flotante aleatorio es: %.2f\n", numrandom3);
        System.out.printf("Mi número flotante aleatorio es: %.2f\n", numrandom4);

    }

    public void playMathClass() {
        System.out.println("Math use");
        System.out.println("min(1,2): " + Math.min(10,2));
        System.out.println("max(2,700): " + Math.max(2,700));
        System.out.println("pow(10,2):"+Math.pow(10,2));
        System.out.println("the min number (489, 29030, 10):"+Math.min(489,Math.min(29030,10)));
    }

    public void playNewWaySwitch() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Type day of the week:");
        int day = sn.nextInt();
        switch(day) {
            case 1->System.out.println("Monday");
            case 2->System.out.println("Tuesday");
            case 3->System.out.println("Wednesday");
            case 4->System.out.println("Thursday");
            case 5->System.out.println("Friday");
            case 6->System.out.println("Saturday");
            case 7->System.out.println("Sunday");
            default->System.out.println("Invalid Day");
        }
    }

    public void playLoops() {
        int iwhilecnt=0;
        int idowhilecnt=0;
        System.out.println("- Traversing using For: ");
        for(int iforcnt=0; iforcnt<10; iforcnt++) {
            System.out.print(iforcnt+", ");
        }
        System.out.println("\n- Traversing using While: ");
        while(iwhilecnt<10) {
            System.out.print(iwhilecnt++ + ", ");
        }
        System.out.println("\nTraversing using Do-While: ");
        do{
            System.out.print(idowhilecnt++ + ", ");
        }while(idowhilecnt<10);

        System.out.println("\n- Asking for number till -1: ");
        Scanner sn= new Scanner(System.in);
        sn.useDelimiter("\n");
        sn.useLocale(Locale.US);
        int number = 0;
        int suma=0;
        while(number!=-1) {
            suma +=number;
            System.out.println("type a number (-1 to end): ");
            number = sn.nextInt();
        }
        System.out.printf("Suma = %d", suma);
        System.out.println("\n- Show numbers between 0-100 dividable 2 and 3");
        for(int iforcnt=1;iforcnt<=100;iforcnt++){
            if(iforcnt%2==0 && iforcnt%3==0) {
                System.out.print(iforcnt+", ");
            }
        }
    }

    public void playStrings() {
        int ilowerCounter=0, iupperCounter=0;
        char oneChar;
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        System.out.println("Enter a string and count upper and lower case");
        String str = sn.next();
        for(int i=0; i<str.length(); i++) {
            oneChar = str.charAt(i);
            if(Character.isLowerCase(oneChar)) ilowerCounter++;
            if(Character.isUpperCase(oneChar)) iupperCounter++;
        }
        System.out.printf("TOTAL upper(%d) lower(%d)", iupperCounter, ilowerCounter);

        System.out.println("Remove space char in string");
        String newString="";
        for(int i=0; i<str.length(); i++) {
            oneChar = str.charAt(i);
            if(oneChar!=' ') newString+=oneChar;
        }
        System.out.println("String without spaces: "+newString);
        sn.close();
    }
    public void generatingPassword() {
        HiUtilery util = new HiUtilery();
        Scanner sn = new Scanner(System.in);
        System.out.println("Type total chars in password: ");
        int ilong = sn.nextInt();
        StringBuilder password= new StringBuilder();
        String specialChar=" #$%&";
        password.append((char)util.generateRandom('A','Z'));
        for(int i=1; i<ilong; i++) {
            int itypeChar = util.generateRandom(1, 4);
            switch(itypeChar) {
                case 1 -> password.append((char)util.generateRandom('A','Z'));
                case 2 -> password.append((char)util.generateRandom('a', 'z'));
                case 3 -> password.append(util.generateRandom(0,9));
                case 4 -> password.append(specialChar.charAt(util.generateRandom(1,4)));
            }
        }
        System.out.println("Password generated: [" + password + "],long="+password.length());
    }

    public void playFibonacci() {

        int num1=0;
        int num2=1;
        int sum=1;
        Scanner sn = new Scanner(System.in);
        System.out.println("Type the fibonacci position:");
        int position = sn.nextInt();
        for(int i=1; i<position; i++) {
            sum= num1+num2;
            num1 = num2;
            num2 = sum;
        }
        System.out.println("Fibonacci:"+sum);
    }
    
    public static void main(String[] args) {
        ToStartExercises1 app = new ToStartExercises1();
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        System.out.println("\n** Menu **");
        System.out.println("1. say hello");
        System.out.println("2. asking price without iva and show last price...");
        System.out.println("3. is divisible and pair");
        System.out.println("4. playing aleatory numbers");
        System.out.println("5. playing Math class");
        System.out.println("6. playing New Switch Way");
        System.out.println("7. Playing Loops");
        System.out.println("8. playing with String");
        System.out.println("9. Generating password");
        System.out.println("10. Fibonacci");

        int opt = Integer.parseInt(sc.nextLine());
        switch (opt) {
            case 1 -> app.sayhello();
            case 2 -> app.askPriceWhitoutIva();
            case 3 -> app.isDivisibleAndPair();
            case 4 -> app.playrandomNumbers();
            case 5 -> app.playMathClass();
            case 6 -> app.playNewWaySwitch();
            case 7 -> app.playLoops();
            case 8 -> app.playStrings();
            case 9 -> app.generatingPassword();
            case 10 -> app.playFibonacci();
            default -> System.out.println("**Option not included**");
        }
        sc.close();
    }

}
