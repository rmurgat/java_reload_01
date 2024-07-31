package net.pledin30;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import net.util.HiUtilery;


public class ArraysEjercicio3 {
    private int numbers[] = {52,3,2,1,9,99,2,3,5,99,25,24,38,59,98,12,34,46,58,69,75,43,24,56,15,90,55,49,69,77,88,11};
    private HiUtilery util = new HiUtilery();
 
    private class Student {
        public int id;
        public String name;
        public int age;
    }
    private class Temperature {
        public int day;
        public double mintemp;
        public double maxtemp;
        public double media;
    }
    public class Match {
        public int team1;
        public int team2;
        char result;

        public String toString() {
            return "team1:"+this.team1+",team2:"+this.team2+",result:"+this.result;
        }
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
        int maxage = 0;
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
            System.out.printf("Enter age to Studden %d: ",(i+1));
            students[i].age=Integer.parseInt(scan.nextLine());
            maxage = Math.max(students[i].age,maxage);
            sum+=students[i].age;

        }
        scan.close();
        double media = (double)sum/(i);
        System.out.printf("Media age: %.2f \n",media);
        System.out.printf("Max age: %d \n",maxage);
        for(int j=0; j<i; j++) {
            Student s = students[j];
            if(s.age>17) {
                System.out.printf("Student %d: ",(j+1));
                System.out.printf("name: %s, age:%d \n", s.name,s.age);
            }
        }
    }

    /*
     * Queremos guardar la temperatura mínima y máxima de 5 días. realiza un programa que de la siguiente información:
     * - La temperatura media de cada día
     * - Los días con menos temperatura
     * - Se lee una temperatura por teclado y se muestran los días cuya temperatura máxima coincide con ella. si no existe 
     *   ningún día se muestra un mensaje de información.
     */
    public void showTemperature() {
        Temperature[] temps = new Temperature[5];
        double min = 100d;
        Scanner scan = new Scanner(System.in);
        System.out.println("Type temperature to 5 days...");
        for(int i=0; i<5; i++) {
            temps[i] = new Temperature();
            String data = "";
            System.out.println("Enter next data: day, min-temp, max-temp ");
            data = scan.nextLine();
            String[] in = data.split(",");
            temps[i].day = Integer.parseInt(in[0]);
            temps[i].mintemp = Double.parseDouble(in[1]);
            temps[i].maxtemp = Double.parseDouble(in[2]);
            temps[i].media = (temps[i].mintemp + temps[i].maxtemp)/2;
            min = Math.min(min,temps[i].mintemp);
        }
        System.out.println("Printing result:");
        for (Temperature t : temps) {
            System.out.printf(" Temperature day=%d, min=%f, max=%f, media=%f %s\n", t.day, t.mintemp, t.maxtemp, t.media, (t.mintemp==min?"(min)":""));
        }
        scan.close();
    }

    /*
     * Ejercicio 10:
     *   Diseñar el algoritmo correspondiente a un programa, que:
     *   Crea una tabla bidimensional de longitud 5x5 y nombre ‘matriz’.
     *   Carga la tabla con valores numéricos enteros.
     *   Suma todos los elementos de cada fila y todos los elementos de cada columna visualizando los resultados en pantalla.
     */
    public void showMatrix() {
        int[][] matrix = { {1,2,3,4,5},{2,6,7,8,9},{3,10,11,12,13},{4,14,15,16,17},{5,18,19,20,21}};
        int[] sumren = new int[5];
        int[] sumcol = new int[5];
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                sumren[i]+=matrix[i][j];
                sumcol[j]+=matrix[i][j];
            }
        }
        for(int i=0; i<5; i++) {
            System.out.printf("total ren[%d]=%d col[%d]=%d \n",i,sumren[i],i,sumcol[i]);
        }
    }

    /*
     * Ejercicio 11Permalink
     * Diseñar el algoritmo correspondiente a un programa, que:
     *  Crea una tabla bidimensional de longitud 5x5 y nombre ‘diagonal’.
     *  Carga la tabla de forma que los componentes pertenecientes a la diagonal de la matriz tomen el valor 1 y el resto el valor 0.
     *  Muestra el contenido de la tabla en pantalla.
     */
    public void showDiagonalMatrix() {
        int[][] diagonal = new int[5][5];
        for(int i=0; i<5; i++) {
            for(int j=0;j<5;j++){ 
                diagonal[i][j]=(i==j?1:0);
            }
        }
        System.out.println("printing Matrix:");
        util.printBidMatrix(diagonal);        
    }

    /*
     * Ejercicio 12:
     *   Crea una tabla bidimensional de longitud 5x15 y nombre ‘marco’.
     *   Carga la tabla con dos únicos valores 0 y 1, donde el valor uno ocupará las posiciones o elementos que delimitan la tabla, es decir, las más externas, mientras que el resto de los elementos contendrán el valor 0.
     *   111111111111111
     *   100000000000001
     *   100000000000001
     *   100000000000001
     *   111111111111111
     *   Visualiza el contenido de la matriz en pantalla. 
    */
    private void showFrame() {
        int[][] frame = new int[5][5];
        for(int i=0; i<5; i++) {
            for(int j=0;j<5;j++){ 
                if(i==0||i==4){ 
                    frame[i][j]=1; 
                }
                else if(j==0||j==4){
                    frame[i][j]=1; 
                }else 
                    frame[i][j]=0;
            }
        }        
        System.out.println("printing Matrix and Frame:");
        this.util.printBidMatrix(frame);        
   }

   /*
    * Ejercicio 13:
    * De una empresa de transporte se quiere guardar el nombre de los conductores que tiene, 
    * y los kilómetros que conducen cada día de la semana.
    * Para guardar esta información se van a utilizar dos arreglos:
    * Nombre: Vector para guardar los nombres de los conductores.
    * kms: Tabla para guardar los kilómetros que realizan cada día de la semana.
    * Se quiere generar un nuevo vector (“total_kms”) con los kilómetros totales que realza cada conductor.
    * Al finalizar se muestra la lista con los nombres de conductores y los kilómetros que ha realizado.
    */
    public void showTransportVector() {
        String[] names = { "Fredy","Horacio","Pedro","Ramiro","Juan"};
        int[][] table = {   {100, 520, 610, 451, 1001, 910, 710}, 
                            {200, 503, 606, 452, 1020, 901, 701}, 
                            {300, 506, 606, 453, 1300, 902, 710}, 
                            {400, 560, 670, 454, 1003, 920, 705}, 
                            {500, 600, 607, 455, 1030, 903, 750},                             
                        };
        int[] total_kms = new int[5];
        for(int i=0; i<5; i++) {
            int sum = 0;
            for(int j=0; j<7; j++) {
                sum+=table[i][j];
            }
            total_kms[i]=sum;
        }
        System.out.println("Printing Driver list");
        for(int i=0; i<5; i++) {
            System.out.printf("Driver %s, total_kms=%d\n",names[i],total_kms[i]);
        }
    }

    /*
     * Crear un programa que lea los precios de 5 artículos y las cantidades vendidas por una empresa en sus 4 sucursales. Informar:
     * - Las cantidades totales de cada articulo.
     * - La cantidad de artículos en la sucursal 2.
     * - La cantidad del articulo 3 en la sucursal 1.
     * - La recaudación total de cada sucursal.
     * - La recaudación total de la empresa.
     * - La sucursal de mayor recaudación.
     */
    public void showStoresAndArticles() {
        String[] articles = {"Vodka Red Beard", "Bacardi", "Ron Cuba", "Wisky Scotlan", "Beer Corona"};
        double[] prices = new double[5];
        double[] sum = new double[4];
        double grantotal=0;
        double max=0;
        int sells[][] = new int[5][4];
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter prices for earch article");
        for(int i=0; i<5; i++) {
            System.out.printf("Article %s: ", articles[i]);
            System.out.print("Enter price: ");
            prices[i] = Double.parseDouble(scan.nextLine());
            System.out.println("Type sells to 4 stores:");
            System.out.print("Store 1: ");
            sells[i][0]=Integer.parseInt(scan.nextLine());
            System.out.print("Store 2: ");
            sells[i][1]=Integer.parseInt(scan.nextLine());
            System.out.print("Store 3: ");
            sells[i][2]=Integer.parseInt(scan.nextLine());
            System.out.print("Store 4: ");
            sells[i][3]=Integer.parseInt(scan.nextLine());
        }
        System.out.println("Printing total sells by article");
        for(int i=0; i<5; i++) {
            System.out.printf(" %s, total=%d \n ", articles[i], sells[i][0]+sells[i][1]+sells[i][2]+sells[i][3]);
        } 

        System.out.println("La cantidad de artículos en la sucursal 2.");
        for(int i=0; i<5; i++) {
            System.out.printf(" %s, quantity=%d \n ", articles[i], sells[i][1]);
        }

        System.out.println("La cantidad del articulo 3 en la sucursal 1: "+ sells[2][0]);

        System.out.println("La recaudación total de cada sucursal.");
        for(int store=0; store<4; store++) {
            sum[store] = 0d;
            for(int article=0; article<5; article++) {
                sum[store]+=sells[article][store]*prices[article];
            }
            System.out.printf("Store %d = %f\n",(store+1),sum[store]);
            grantotal = grantotal + sum[store];
            max = Math.max(max,sum[store]);
        }

        System.out.printf("La recaudación total de la empresa. %f",grantotal);

        System.out.println("La sucursal de mayor recaudación.");
        for(int store=0; store<4; store++) {
            if(max == sum[store]) {
                System.out.printf("%d,",store);
            }
        }
        scan.close();
    }

    /*
     * Crear un programa de ordenador para gestionar los resultados de la quiniela de fútbol. Para ello vamos a utilizar dos tablas:
     * Equipos: Que es una tabla de cadenas donde guardamos en cada columna el nombre de los equipos de cada partido. En la quiniela se indican 15 partidos.
     * Resultados: Es una tabla de enteros donde se indica el resultado. También tiene dos columnas, en la primera se guarda el número de goles del equipo que está guardado en la primera columna de la tabla anterior, y en la segunda los goles del otro equipo.
     * El programa ira pidiendo los nombres de los equipos de cada partido y el resultado del partido, a continuación se imprimirá la quiniela de esa jornada.
     */
    public void showSoccerPool() {
        String[] teams = {"1-Cruz Azul", "2-America", "3-Pumas", "4-Atlante"};
        Match[] table = new Match[20];
        int imatches = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Teams:\n");
        Arrays.stream(teams).forEach(t->{
            System.out.println(t); });
        System.out.println("Enter Matches counter: ");
        imatches = Integer.parseInt(scan.nextLine());
        System.out.println("Entering match info");
        for(int i=0;i<imatches; i++) {
            table[i] = new Match();
            System.out.printf("[MATCH NO %d]\n",(i+1));
            System.out.print("Choose team 1: ");
            table[i].team1 = Integer.parseInt(scan.nextLine());
            System.out.print("Choose team 2: ");
            table[i].team2 = Integer.parseInt(scan.nextLine());
            System.out.print("Type result: ");
            table[i].result = scan.nextLine().charAt(0);
        }
        System.out.println("Printing Table");
        util.printObjectArray(table, imatches);
        scan.close();
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
        System.out.println("9. Enter temperature to show cold weather");
        System.out.println("10. Matrix");
        System.out.println("11. Show Diagonal Matrix");
        System.out.println("12. Matrix and Frame");
        System.out.println("13. Trasport Vectors");
        System.out.println("14. Store and Articles");
        System.out.println("15. Soccer Pool");
        System.out.println("99. Exit");
        System.out.println("Select one option...");
        int opt = Integer.parseInt(scan.nextLine());
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
            case 9:
                app.showTemperature();
                break;
            case 10:
                app.showMatrix();
                break;
            case 11:
                app.showDiagonalMatrix();
                break;
            case 12:
                app.showFrame();
                break;
            case 13:
                app.showTransportVector();
                break;
            case 14:
                app.showStoresAndArticles();
            case 15:
                app.showSoccerPool();
            case 99: 
                break;
            default:
                System.out.println("Option not recognized");
        }
        System.out.println();
        scan.close();        
    }
}
