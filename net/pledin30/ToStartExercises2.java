package net.pledin30;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import net.util.HiUtilery;

/**
 * Practices
 * Youtube Channel: https://youtu.be/edKdQcbFzHI?si=nKUii3k-2hvcW8KM
 */
public class ToStartExercises2 {
    HiUtilery util = new HiUtilery();

    public void playFirstTimeArrays() {
        int[] values = new int[50];
        int total = 0;
        Scanner sn = new Scanner(System.in);
        System.out.println("PLAYING WITH ARRAYS");
        for(int i=0;i<10;i++) {
            System.out.printf("Type array[%d]: ", (i+1));
            values[i] = sn.nextInt();
        }
        System.out.println("PRINTING...");
        for(int i=0; i<10; i++) {
            total+=values[i];
            System.out.printf("%d, ", values[i]);
        }
        System.out.printf("\n Suma: %d, media: %.2f ", total, (float)total/10);
    }

    public void gettingOlderGayFromArray() {
        int idxolder = 0;
        int[] ages = {30, 10,20, 50, 15};
        String[] names = {"Fredy","Mauricio","Carlos","Juan","Rodrigo"};

        for(int i=0; i<ages.length; i++) {
            if(ages[idxolder]<ages[i]) idxolder=i;
        }
        System.out.printf("pos older: %d, name: %s, age: %d", idxolder + 1, names[idxolder], ages[idxolder] );
    }

    public void testingCapicuaArray() {
        int [] array = {5,4,3,4,5};
        int [] inverted = new int[array.length];
        for(int i=0, j=array.length-1; i<array.length; i++, j--) {
            inverted[i] = array[j];
        }
        if(Arrays.equals(array, inverted)) {
            System.out.println("Es CAPICUA");
        } else {
            System.out.println("NO ES CAPICUA");
        }
        System.out.println("Array: " + Arrays.toString(inverted));
    }

    public void playArrayFussion() {
        char[] name = {'R','u','b','e','n',' '};
        char[] morespaces = {' ', ' '};
        char[] surname = {'M','u','r','g','a'};

        char[] result = new char[name.length+morespaces.length+surname.length];
        int idxresult = 0;
        for(int i=0; i<name.length; i++) {
            result[idxresult++]=name[i];
        }
        for(int i=0; i<morespaces.length; i++) {
            result[idxresult++]=morespaces[i];
        }
        for(int i=0; i<surname.length; i++) {
            result[idxresult++]=surname[i];
        }
        System.out.printf("Array fussioned: %s", Arrays.toString(result));
    }

    public void setAleatoryNumAtArray() {
        int[] aleatory = new int[100];
        for(int i=0; i<aleatory.length; i++) {
            aleatory[i] = util.generateRandom(1, 1000);
        }
        System.out.printf("Aleatory Numbers: %s", Arrays.toString(aleatory));
    }

    public void proccessMatrix() {
        int[][] matrix = new int[5][5];
        Scanner sn = new Scanner(System.in);
        System.out.println("Please Type Numbers to Matrix");
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                System.out.printf("matrix[%d][%d]:",i+1,j+1);
                matrix[i][j] = sn.nextInt();
            }
        }
        System.out.println("Matrix values are: "); 
        for(int i=0; i<matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        
    }

    public static void main(String[] args) {
        int ioption = 0;
        ToStartExercises2 app = new ToStartExercises2();
        Scanner sn = new Scanner(System.in);
        System.out.println("----[ MAIN MENU ]---");
        System.out.println("1. Starting arrays");
        System.out.println("2. Getting old gay from array");
        System.out.println("3. Testing CAPIQUA arrays");
        System.out.println("4. Playing Array Fussion");
        System.out.println("5. Setting Aleatory Numbers in Array");
        System.out.println("6. Procesing Matrixes");

        ioption = sn.nextInt();
        switch(ioption) {
            case 1 -> app.playFirstTimeArrays();
            case 2 -> app.gettingOlderGayFromArray();
            case 3 -> app.testingCapicuaArray();
            case 4 -> app.playArrayFussion();
            case 5 -> app.setAleatoryNumAtArray();
            case 6 -> app.proccessMatrix();
            default -> System.out.println("Option NOT recognized");
        }
        sn.close();
    }

}
