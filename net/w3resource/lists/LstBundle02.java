import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import net.util.HiUtilery;

public class LstBundle02 {
    HiUtilery util = new HiUtilery();

    public void sortingArrayListManually() {
        List<String> list = new ArrayList<>();
        
        for(int i=0; i<100; i++) 
            list.add(util.generateRandomString(5));

        System.out.printf("Original ArrayList size: %d, content: %s\n", list.size(), list);            
        // sorting...
        for(int i=0; i<list.size(); i++) 
            for(int j=i+1; j<list.size(); j++) 
                if(list.get(i).compareTo(list.get(j))>0) {
                    String tmp = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i,tmp);
                }
        System.out.printf("Sorted ArrayList size: %d content: %s\n", list.size(), list);

        List<String> list1 = new ArrayList<>();
        ListIterator<String> iterator = list.listIterator(list.size());
        while(iterator.hasPrevious()) {
            list1.add(iterator.previous());
        }

        System.out.printf("Sorted ArrayList(reversed) size: %d content: %s\n", list1.size(), list1);        
    }

    public static void main(String[] args) {
        LstBundle02 app = new LstBundle02();
        Scanner sn = new Scanner(System.in);
        System.out.println("MAIN MENU");
        System.out.println("1. Sorting ArrayList Manualy");
        System.out.println("[Select Option:]");
        int option = sn.nextInt();
        switch (option) {
            case 1-> app.sortingArrayListManually();
            default -> System.out.println("Options not allowed");
        }

    }
    
}
