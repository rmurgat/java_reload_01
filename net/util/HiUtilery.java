package net.util;

public class HiUtilery {

    public String toString() {
        return "MyUtilery";
    }

    public void printBidMatrix(int[][] matrix) {
        for(int i=0; i<5; i++) {
            for(int j=0;j<5;j++) {
                System.out.printf("%d, ", matrix[i][j]);
            }
            System.out.println();
        }
    }    
    public void printObjectArray(Object[] arr, int counter) {
        for(int i=0; i<counter; i++) {
            System.out.printf("%s\n", arr[i].toString());
        }

    }
}
