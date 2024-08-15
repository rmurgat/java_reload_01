package net.w3resource.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import net.util.HiUtilery;;

/**
 * LINKEDLIST Exercises
 * wiki id: [wiki_autostudy_java_linkedlist]
 */
public class LstBundle03 {
    HiUtilery util = new HiUtilery();

    public class Book {
        public String title="";
        public String genre="";
        public int pages=0;
        public Book(String title, String genre, int pages) {
            this.title = title;
            this.genre = genre;
            this.pages = pages;
        }
        public String toString() {
            return "[title: " + this.title + ", genre: " + this.genre + ", pages: " + pages + "]";
        }
    }

    public void travelingValues() {
        long start, finish;

        List<String> list0 = new ArrayList<>();
        for(int i=0; i<1000; i++) 
            list0.add(util.generateRandomString(4));
        List<String> list1 = new LinkedList<>();
        for(int i=0; i<1000; i++) 
            list1.add(util.generateRandomString(4));
        start = System.currentTimeMillis(); 
        list0.forEach(System.out::print);
        finish = System.currentTimeMillis();
        System.out.println("traveling time arraylist [" + (finish - start) + "]");
        start = System.currentTimeMillis(); 
        list1.forEach(System.out::print);
        finish = System.currentTimeMillis();
        System.out.println("traveling time linkedlist [" + (finish - start) + "]");
    }

    public void insertingValues() {
        long start, finish;

        List<String> list0 = new ArrayList<>();

        start = System.currentTimeMillis();

        for(int i=0; i<100; i++) 
            list0.add(util.generateRandomString(4));

        finish = System.currentTimeMillis();
        System.out.println("time inserting arraylist [" + (finish - start) + "]");

        List<String> list1 = new LinkedList<>();

        start = System.currentTimeMillis();
        for(int i=0; i<100; i++) 
            list1.add(util.generateRandomString(4));
        finish = System.currentTimeMillis();

        System.out.println("time inserting linkedlist [" + (finish - start) + "]");
    }

    public void sortingValues() {
        long start, finish;

        // ------------------ USING ARRAY-----------------
        String[] array = new String[1000];
        for(int i=0; i<1000; i++) {
            array[i] = util.generateRandomString(4) + "00";
        }
        start = System.currentTimeMillis();
        for(int i=0; i<array.length; i++)
            for(int j=i+1; j<array.length; j++)
                if(array[j].compareTo(array[i])<0) {
                    String tmp = array[j];
                    array[j]= array[i];;
                    array[i] = tmp;
                }
        finish = System.currentTimeMillis();
        System.out.println("time sorting/swifting array [" + (finish - start) + "]");

         // ------------------ USING ARRAYLIST-----------------
        List<String> list0 = new ArrayList<>();
        for(int i=0; i<1000; i++) {
            list0.add(util.generateRandomString(4) + "00");
        }
        start = System.currentTimeMillis();
        for(int i=0; i<list0.size(); i++)
            for(int j=i+1; j<list0.size(); j++)
                if(list0.get(j).compareTo(list0.get(i))<0) {
                    String tmp = list0.get(j);
                    list0.set(j,list0.get(i));
                    list0.set(i,tmp);
                }
        finish = System.currentTimeMillis();
    
        System.out.println("time sorting/swifting arraylist [" + (finish - start) + "]");

        // ------------------ USING LINKEDLIST-----------------
        List<String> list1 = new LinkedList<>();
        for(int i=0; i<1000; i++) 
            list1.add(util.generateRandomString(4) + "00");

        start = System.currentTimeMillis();
        for(int i=0; i<list1.size(); i++)
            for(int j=i+1; j<list1.size(); j++)
                if(list1.get(j).compareTo(list1.get(i))<0) {
                    String tmp = list1.get(j);
                    list1.set(j,list1.get(i));
                    list1.set(i,tmp);
                }
        finish = System.currentTimeMillis();
        System.out.println("time sorting/swifting linkedlist [" + (finish - start) + "]");
    }

    public void searchingValue() {
        long start, finish;
        String tofindout = "";

        List<String> list0 = new ArrayList<>();
        for(int i=0; i<1000; i++) 
            list0.add(util.generateRandomString(10));
        Collections.sort(list0);
        List<String> list1 = new LinkedList<>();
        for(int i=0; i<1000; i++) 
            list1.add(util.generateRandomString(10));
        Collections.sort(list1);

        tofindout = list0.get(list0.size()-1);
        start = System.currentTimeMillis();
        list0.indexOf(tofindout);
        finish = System.currentTimeMillis();
        System.out.printf("\ntime locating last value(%s) ArrayList [%d]", tofindout, (finish - start));

        tofindout = list1.get(list1.size()-1);
        start = System.currentTimeMillis();
        list1.indexOf(tofindout);
        finish = System.currentTimeMillis();
        System.out.printf("\ntime locating last value(%s) LinkedList [%d]", tofindout, (finish - start));
    }

    public void streamingValues() {
        Book l1 = new Book("El señor de los anillos","fantasia",1100);
        Book l2 = new Book("El juego de Ender", "ciencia ficcion", 500);
        Book l3 = new Book("La fundacion", "ciencia ficcion", 500);
        Book l4 = new Book("Los pilares de la tierra", "historica", 1200);
        List<Book> list = Arrays.asList(l1,l2,l3,l4);
        list.stream()
            .filter(libro->libro.pages>1000)
            .forEach(System.out::println);
    }

    public void extractingFirstandLast() {
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        List<String> list = new LinkedList<>();
        for(int i=0; i<100; i++) 
            list.add(util.generateRandomString(2));
        list.forEach(x->System.out.printf("%s,",x));
        System.out.println("Type string to search:");
        String toSearch = sn.next();
        list.add(toSearch);
        System.out.println("First Index:"+ list.indexOf(toSearch) + ", LastIndex: " + list.lastIndexOf(toSearch));
    }

    public void showingLinkedList() {
        List<String> list = new LinkedList<>();
        for(int i=0; i<100; i++) 
            list.add(util.generateRandomString(2));
        System.out.println("\nOriginal List:");
        list.forEach(x->System.out.printf("%s, ",x));
        System.out.println("\nPrinting Sorted: ");
        Set<String> set1 = list.stream().collect(Collectors.toSet());
        set1.stream().forEach(x->System.out.printf("%s, ",x));
    }

    public static void main(String[] args) {
        LstBundle03 app = new LstBundle03();
        Scanner sn = new Scanner(System.in);
        System.out.println("MAIN MENU");
        System.out.println("1. Traveling values in ArrayList and LinkedList");
        System.out.println("2. Inserting values in ArrayList and LinkedList");
        System.out.println("3. Sorting values in LikendList");
        System.out.println("4. Searching value in LinkedList");
        System.out.println("5. Streaming values in LinkedList");
        System.out.println("6. Extracting First and Last Ocurrence in LinkedList");
        System.out.println("7. Showing values in LinkedList");

        int option = sn.nextInt();
        switch (option) {
            case 1 -> app.travelingValues();
            case 2 -> app.insertingValues();
            case 3 -> app.sortingValues();
            case 4 -> app.searchingValue();
            case 5 -> app.streamingValues();
            case 6 -> app.extractingFirstandLast();
            case 7 -> app.showingLinkedList();

            default -> System.out.println("Option not allowed");
        }
        sn.close();
    }
}
