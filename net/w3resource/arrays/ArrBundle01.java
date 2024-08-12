package net.w3resource.arrays;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import net.util.HiUtilery;

/*
 * https://www.w3resource.com/java-exercises
 */
public class ArrBundle01 {
    final int MAX = 20;
    String[] log = new String[MAX];
    HiUtilery util = new HiUtilery();

    class ValueOcurrences {
        public long hashvalue=0;
        public String value="";
        public int ocurrences=0;
    }

    public void dropInLog(String str) {
        for(int i=0; i<log.length; i++) 
            if(log[i]==null) {
                log[i] = str;
                break;
            }
    }

    public void showLog() {
        System.out.println("\nSHOWING MEMORY LOG");
        for(int i=0; i<log.length; i++) {
            if(log[i]==null) break;
            System.out.print("\n"+log[i]);
        }

    }

    public void sortingArrayInt() {

        int[] array = new int[MAX];
        int[] sorted = new int[MAX];
        Random rand = new Random();
        for(int i=0; i<MAX; i++) {
            array[i] = rand.nextInt(100, 1000);
        }
        System.out.println("Original array: " + Arrays.toString(array));
        sorted = Arrays.copyOf(array,MAX);
        Arrays.sort(sorted);
        System.out.println("Original sorted by Arrays Lib: " + Arrays.toString(sorted));

        for(int i=0; i<array.length; i++)
            for(int j=i+1; j<array.length; j++) 
                if(array[i]>array[j]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
        System.out.printf("My sorted: %s\n", Arrays.toString(array));

    }

    public void sortingArrayString() {
        String[] array = { "Xico", "Zamperio", "Ruben", "Fredy", "Antonio", "Joel", "Ronaciano", "Bertholdo", "Adolfo", "Xavier", "Javier"};
        String[] sorted = Arrays.copyOf(array, array.length);
        Arrays.sort(sorted);
        System.out.println("Original Array: " + Arrays.toString(array));
        System.out.println("Original Sorted Array: " + Arrays.toString(sorted));
        for(int i=0; i<array.length; i++) 
            for(int j=i+1; j<array.length; j++) 
                if(array[j].compareTo(array[i])<0)  {
                    String tmp = array[j];
                    array[j]=array[i];
                    array[i]=tmp;
                }
        System.out.printf("My sorted: %s\n", Arrays.toString(array));
    }

    public void printMaxtrix10x10() {
        final int MAX10 = 10;
        char[][] matrix = new char[MAX10][MAX10];
        int ichar = 65;
        for(int i=0; i<MAX10; i++)
            for(int j=0; j<MAX10; j++) 
                matrix[i][j]=(char)ichar++;            

        for(int i=0; i<MAX10; i++) {
            for(int j=0; j<MAX10; j++) 
                System.out.printf("%c ", matrix[i][j]);
            System.out.println();
        }
    }

    /* 
        For example, 0 + 1= 1, 1+ 2= 3, 2 +3= 5, 3 + 5=8, and so on. 
    */
    public void sumValuesFibonacciArray() {
        int MAX=50;
        long[] fibonacci = new long[MAX];
        long n1 = 0;
        long n2 = 1;
        long total = 0;
        for(int i=1; i<MAX; i++) {
            fibonacci[i] = n1 + n2;
            n1 = n2; 
            n2 = fibonacci[i];
            total += fibonacci[i];
        }
        System.out.printf("Fibonaci total %d, array: %s", total, Arrays.toString(fibonacci));
    }

    public void searchingValueInArray() {
        final int MAX_VALUES = 50;
        Scanner sn = new Scanner(System.in);
        Random rand = new Random();
        int ilocatedin = -1;
        int[] values = new int[MAX_VALUES];
        for(int i=0; i<MAX_VALUES; i++) 
            values[i] = rand.nextInt(MAX_VALUES,MAX_VALUES+MAX_VALUES);
        System.out.println("Array un-sorted is " + Arrays.toString(values));
        sortingArray(values);
        System.out.println("Array sorted is " + Arrays.toString(values));
        System.out.println("Give the number to search");
        int tosearch = sn.nextInt();
        for(int i=0; i<MAX_VALUES; i++) {
            if(values[i]==tosearch) 
                ilocatedin = i;
        }
        if(ilocatedin>=0) {
            System.out.printf("Value located in pos %d", ilocatedin);
        }else{
            System.out.println("Value NOT EXIST in Array!");
        }
    }

    private void sortingArray(int[] array) {
        for(int i=0; i<array.length; i++) 
            for(int j=i+1; j<array.length; j++) 
                if(array[i]>array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
    }

    public void removingElementInArray() {
        final int MAX_REMOVE = 100;
        int[] value = new int[MAX_REMOVE];
        int[] value2 = new int[MAX_REMOVE];
        Scanner sn = new Scanner(System.in);
        Random rand = new Random();
        int i2remove = 0;
        int idx2=0;
        for(int i=0; i<MAX_REMOVE; i++) 
            value[i] =  rand.nextInt(100, 120);
        System.out.println("Showing original array " + Arrays.toString(value));
        System.out.println("Type number to remove");
        i2remove = sn.nextInt();

        for(int i=0; i<MAX_REMOVE; i++) {
            if(value[i]==i2remove) continue;
            value2[idx2++] = value[i];
        }
        
        System.out.println("Showing final array :");
        for(int i=0; i<idx2; i++) 
            System.out.printf("%d, ", value2[i]);

        sn.close();
    }

    public void insertingElementInArray() {
        int[] values = {1,2,3,4,5,6,7,8,9,10};
        
        int[] res = this.insertValueInArray(values, 5, 10);
        System.out.println("Final array :" + Arrays.toString(res));
    }

    private int[] insertValueInArray(int[] array, int pos, int value) {
        int[] res = new int[array.length+1];
        int idx = 0;
        for(int i=0; i<array.length; i++) {
            if(i==pos) res[idx++] = value;
            res[idx++] = array[i];
        }
        return res;
    } 

    public void showMaxMinValueInArray() {
        final int MAX_MIN=100;
        Random rand = new Random();
        int[][] values = new int[MAX_MIN][MAX_MIN];
        int max=0;
        int min=1000+1;
        for(int i=0; i<MAX_MIN; i++) 
            for(int j=0; j<MAX_MIN; j++)
                values[i][j] = rand.nextInt(100,1000);

        for(int i=0; i<MAX_MIN; i++) {
            System.out.println("Original Matrix: " + Arrays.toString(values[i]));
        }

        for(int i=0; i<MAX_MIN; i++) 
            for(int j=0; j<MAX_MIN; j++){
                min = Math.min(min,values[i][j]);
                max = Math.max(max,values[i][j]);
            }
        System.out.printf("The values are min: %d, max: %d", min, max);

    }

    public void reversingArray() {
        int[] values = { 1,2,3,4,5,65,7,78,9,0,9};
        int[] result = new int[values.length];
        int idx = 0;
        for(int i=values.length-1; i>-1; i--) {
            result[idx++] = values[i];
        }
        System.out.println("Array reversed: " + Arrays.toString(result));
    }

    public void findingDuplicatedValuesInArray() {
        final int MAX_DUPLICATED=100;
        ValueOcurrences[] counters = new ValueOcurrences[MAX_DUPLICATED];
        Random rand = new Random();
        int[] values = new int[MAX_DUPLICATED];
        for(int i=0; i<values.length; i++) values[i]=rand.nextInt(100,200);
        System.out.println("Original Array: " + Arrays.toString(values));
        for(int i=0; i<MAX_DUPLICATED; i++) 
            addOcurrences(counters, Integer.toString(values[i]), 1);
        
        this.showOcurrences(counters);
    }

    public void findingDuplicatedValuesInArrayString() {
        final int MAX_DUPLICATED_STRING=100;
        ValueOcurrences[] counters = new ValueOcurrences[MAX_DUPLICATED_STRING];
        String[] values = new String[MAX_DUPLICATED_STRING];
        for(int i=0; i<MAX_DUPLICATED_STRING; i++) {
            values[i] = util.generateRandomString(4);
        }
        System.out.println("Original Array: " + Arrays.toString(values));
        for(int i=0; i<MAX_DUPLICATED_STRING; i++) 
            addOcurrences(counters, values[i], 1);
        
        this.showOcurrences(counters);
    }


    private void addOcurrences(ValueOcurrences[] ocurrs, String value, int ocurrences) {

        for(int i=0; i<ocurrs.length; i++) {
            ValueOcurrences obj = ocurrs[i];
            if(obj==null) {
                obj = new ValueOcurrences();
                obj.hashvalue = value.hashCode();
                obj.value = value;
                obj.ocurrences = ocurrences;
                ocurrs[i] = obj;
                break;
            } 
            if(obj.hashvalue == value.hashCode()) {
               obj.ocurrences += ocurrences;
               break;
            }
        }
    }

    private void showOcurrences(ValueOcurrences[] ocurrs) {
        System.out.println("Showing [ValueOcurrences] Counter");
        for(int i=0; i<ocurrs.length; i++) {
            ValueOcurrences obj = ocurrs[i];
            if(obj!=null) {
                System.out.printf("[value:] %s [ocurr:] %d\n", obj.value, obj.ocurrences);
            }
        }
    }

    public void findingCommonElement2Arrays() {
        Random rand = new Random();
        final int MAX_COMMONELEMENTS1 = 100;
        int[] arr1 = new int[MAX_COMMONELEMENTS1];
        int[] arr2 = new int[MAX_COMMONELEMENTS1];

        for(int i=0; i<arr1.length; i++) arr1[i]=rand.nextInt(0,100);
        for(int i=0; i<arr2.length; i++) arr2[i]=rand.nextInt(0,100);

        for(int i: arr1)
            for(int k: arr2)
                if(i==k) 
                    dropInLog("Number: " + i +" is in arr2 too!");
        showLog();
    }

    public void findingCommonElement2StringArrays() {
        final int MAX_COMMONELEMENTS2 = 20;
        String[] arr1 = new String[MAX_COMMONELEMENTS2];
        String[] arr2 = new String[MAX_COMMONELEMENTS2];

        for(int i=0; i<arr1.length; i++) arr1[i]=util.generateRandomString(2);
        for(int i=0; i<arr2.length; i++) arr2[i]=util.generateRandomString(2);
        System.out.print("\nArray 1:");
        for(String s1: arr1) System.out.print(s1+", ");
        System.out.print("\nArray 2:");
        for(String s1: arr2) System.out.print(s1+", ");

        for(String s1: arr1)
            for(String s2: arr2)
                if(s1.equals(s2)) 
                    dropInLog("Number: " + s1 +" is in arr2 too!");
        showLog();
    }

    public void removingDuplicatedElementsInArray() {
        Random rand = new Random();
        final int MAX_DUPLICATED_VALUES = 200;
        int idx=0;
        int values[] = new int[MAX_DUPLICATED_VALUES];
        int res[] = new int[MAX_DUPLICATED_VALUES];
        for(int i=0; i<values.length; i++)
           values[i] =  rand.nextInt(0, 20);

        for(int i=0; i<values.length; i++) {
           boolean located = false;
           for(int j=0; j<idx; j++) 
              if(values[i]==res[j]) {
                located = true;
                break;
              }
            if(!located) res[idx++]=values[i];
        }
        System.out.println("Original Array" + Arrays.toString(values));
        System.out.println("No-duplicated Array" + Arrays.toString(Arrays.copyOfRange(res,0,idx)));
    }

    public void findingLargestStringInArray() {
        final int MAX_LARGEST=20;
        String[] values = new String[MAX_LARGEST];
        int maxlength = 0;
        String maxvalue = "";
        for(int i=0; i < values.length; i++) {
            values[i] = util.generateRandomString(-1);
        }
        System.out.println("Original Array: ");
        for(String s: values) {
            System.out.print("\n"+s+", length:"+s.length());
        }

        for(String s: values) {
            if(s.length() > maxlength) {
                maxlength = s.length();
                maxvalue = s;
            }
        }

        System.out.printf(" Max length: %d,  Max Value: %s ", maxlength, maxvalue);
        
    }

    public void finding2doSmallestElementInArray() {
        String[] values = {"Walter", "Erenesto", "Jair", "Ruben","Fredy","Yair", "Alberto","Antonio","Mercedez","Horacio","Ricardo","Eva", "Zoel", "Romulo", "Francisco"};
        
        // sorting array...
        for(int i=0; i<values.length; i++)
            for(int j=i+1; j<values.length; j++) 
                if(values[j].compareTo(values[i])<0) {
                    String tmp = values[i];
                    values[i]=values[j];
                    values[j]=tmp;
                }
            
        System.out.println("Array Sorted: " + Arrays.toString(values));
        System.out.println("2do Value small:" + values[1]);
    }

    public void Adding2Matrix() {
        final int MAX_MATRIXADD=5;
        Random rand = new Random();
        int[][] mat1 = new int[MAX_MATRIXADD][MAX_MATRIXADD];
        int[][] mat2 = new int[MAX_MATRIXADD][MAX_MATRIXADD];
        int[][] res = new int[MAX_MATRIXADD][MAX_MATRIXADD];
        for(int i=0; i<MAX_MATRIXADD; i++)
            for(int j=0; j<MAX_MATRIXADD; j++) {
                mat1[i][j] = rand.nextInt(0,100);
                mat2[i][j] = rand.nextInt(101,200);
            }
        System.out.println("MATRIX 1:");
        for(int i=0; i<MAX_MATRIXADD; i++) 
            System.out.println(Arrays.toString(mat1[i]));

        System.out.println("MATRIX 2:");
        for(int i=0; i<MAX_MATRIXADD; i++) 
            System.out.println(Arrays.toString(mat2[i]));

        for(int i=0; i<MAX_MATRIXADD; i++)
            for(int j=0; j<MAX_MATRIXADD; j++) 
                res[i][j] = mat1[i][j]+mat2[i][j];
        
        // showing resulting matrix
        System.out.println("MATRIX RESULTED:");
        for(int i=0; i<MAX_MATRIXADD; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        ArrBundle01 app = new ArrBundle01();

        int opc = 0;
        System.out.println("[ BUNDLE 1 MENU ]");
        System.out.println("1. Sorting one array Int");
        System.out.println("2. Sorting one array String");
        System.out.println("3. Sum values in Fibonaci array");
        System.out.println("4. Print matrix 10x10");
        System.out.println("5. Searching value in array");
        System.out.println("6. Removing elements from Array");
        System.out.println("7. Inserting elements at Array");
        System.out.println("8. Show max + min value at Array");
        System.out.println("9. Reversing Array");
        System.out.println("10. Finding duplicated values in array (int)");
        System.out.println("11. Finding duplicated values in array (String)");
        System.out.println("12. Finding Common elements in two arrays (int)");
        System.out.println("13. Finding Common elements in two arrays (String)");
        System.out.println("14. Removing duplicated elements in array");
        System.out.println("15. Finding largest string in array");
        System.out.println("16. Finding 2do smallest element in array");
        System.out.println("17. Adding two matrices of the same size");
        opc = sn.nextInt();
        switch(opc) {
            case 1 -> app.sortingArrayInt();
            case 2 -> app.sortingArrayString();
            case 3 -> app.sumValuesFibonacciArray();
            case 4 -> app.printMaxtrix10x10();
            case 5 -> app.searchingValueInArray();
            case 6 -> app.removingElementInArray();
            case 7 -> app.insertingElementInArray();
            case 8 -> app.showMaxMinValueInArray();
            case 9 -> app.reversingArray();
            case 10 -> app.findingDuplicatedValuesInArray();
            case 11 -> app.findingDuplicatedValuesInArrayString();
            case 12 -> app.findingCommonElement2Arrays();
            case 13 -> app.findingCommonElement2StringArrays();
            case 14 -> app.removingDuplicatedElementsInArray();
            case 15 -> app.findingLargestStringInArray();
            case 16 -> app.finding2doSmallestElementInArray();
            case 17 -> app.Adding2Matrix();
            default -> System.out.println("Option not defined");
        }
        sn.close();
    }
    
}
