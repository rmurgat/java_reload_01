package net.w3resource.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import net.util.HiUtilery;

/**
 * ARRAYLIST EXERCISES
 * wiki id: [wiki_autostudy_java_arraylist]
 */
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

    public void merging2ArrayLists() {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> listM = new ArrayList<>();
        for(int i=0; i<20; i++) {
            list1.add(util.generateRandomString(6));
            list2.add(util.generateRandomString(10));
        }
        listM.addAll(list1);
        listM.addAll(2,list2);
        System.out.println("a. Method using addAll(): " + listM);

        listM.clear();
        int idx1=0;
        int idx2=0;
        for(int i=0; i<list1.size()+list2.size(); i++) {
            if(i%2==0) listM.add(list2.get(idx2++));
            else listM.add(list1.get(idx1++));
        }
        System.out.println("b. merging using intercalated" + listM);

        listM.clear();
        list1.forEach(x->listM.add(x));
        list2.forEach(x->listM.add(x));
        System.out.println("c. merging using Lambda Function" + listM);

        listM.clear();
        System.out.println("d. merging using Stream");
        Stream.of(list1, list2).forEach(x->{ 
            x.forEach(y->{
                listM.add(y);
            });
        });
        System.out.println(listM);
    }

    public void searchingElementInArrayList() {
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        List<String> list = new ArrayList<>();
        for(int i=0; i<30; i++) 
            list.add(util.generateRandomString(6));

        System.out.println("Original ArrayList: " + list);
        System.out.println("Enter the element to search: ");
        String toLocate = sn.next();
        String found = "";

        for(String name: list) {
            if(name.compareTo(toLocate)==0) 
                found = name;
        }
        System.out.printf("a. using for(), found Element %s\n", found);

        System.out.printf("b. using indexOf(), index to Element: %d\n", list.indexOf(toLocate));

        found = list.stream().filter(x->toLocate.equals(x)).findAny().orElse(null);
        System.out.println("c. using Streams : " + found);

        List<String> cloned = new ArrayList<>(list);
        System.out.println("f. printing ArrayList(list) cloned: " + cloned);
    }

    public void searchingMaxElementInArrayList() {
        List<Integer> list = new ArrayList<>();
        AtomicInteger max = new AtomicInteger(0);
        for(int i=0; i<50; i++)
            list.add(util.generateRandom(0, 10000));
        System.out.println("Original ArrayList: " + list);
        list.forEach(x->{
            max.set(Math.max(x.intValue(), max.intValue()));
        });

        System.out.println("Selecting Max value: " + max.intValue());

    }

    public static void main(String[] args) {
        LstBundle02 app = new LstBundle02();
        Scanner sn = new Scanner(System.in);
        System.out.println("MAIN MENU");
        System.out.println("1. Sorting ArrayList Manualy");
        System.out.println("2. Merging Two ArrayLists");
        System.out.println("3. Searching a particular Element");
        System.out.println("4. Searching Max() value in ArrayList");
        
        
        System.out.println("[Select Option:]");
        int option = sn.nextInt();
        switch (option) {
            case 1-> app.sortingArrayListManually();
            case 2-> app.merging2ArrayLists();
            case 3-> app.searchingElementInArrayList();
            case 4-> app.searchingMaxElementInArrayList();
            default -> System.out.println("Options not allowed");
        }
        sn.close();
    }
    
}
