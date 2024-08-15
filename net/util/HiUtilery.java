package net.util;
import java.util.Random;

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

    public int generateRandom(int ini, int end) {
        Random rand = new Random();
        return rand.nextInt(ini,end+1);
    }

    public String generateRandomString(int len) {
        String[] names = {"Alph","Beta","Gama","Roge","Plut","Venu","Mart","Rigo","Sun","Moon","Earth","Thor","Eva","Bart","Home","Rigo","Musk","Jobs","Gates","Kris","Mich","Gari","Rubi","Fred","Luca","Mike","Kare","Grin","God","Eter", "Zorg", "Wall", "Ness", "Nick", "Hur", "Ala", "Neck"};
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rand = new Random();
        String res=names[rand.nextInt(0, names.length-1)];
        if(len==-1) len = rand.nextInt(5,30);
        for(int i=0; i<len; i++) 
            res+= alphabet.charAt(rand.nextInt(0,alphabet.length()-1));
        return res;
    }    

}
