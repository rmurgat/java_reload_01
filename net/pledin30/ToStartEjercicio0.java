package net.pledin30;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

/**
 * Practices
 * Youtube Channel: https://youtu.be/edKdQcbFzHI?si=nKUii3k-2hvcW8KM
 */
public class ToStartEjercicio0 {

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

    public static void main(String[] args) {
        ToStartEjercicio0 app = new ToStartEjercicio0();
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        System.out.println("\n** Menu **");
        System.out.println("1. say hello");
        System.out.println("2. asking price without iva and show last price...");
        System.out.println("3. is divisible and pair");
        System.out.println("4. playing aleatory numbers");
        System.out.println("5. playing Math class");
        System.out.println("6. playing New Switch Way");
        int opt = Integer.parseInt(sc.nextLine());
        switch (opt) {
            case 1 -> app.sayhello();
            case 2 -> app.askPriceWhitoutIva();
            case 3 -> app.isDivisibleAndPair();
            case 4 -> app.playrandomNumbers();
            case 5 -> app.playMathClass();
            case 6 -> app.playNewWaySwitch();
            default -> System.out.println("**Option not included**");
        }  
        sc.close();              
    }

}
