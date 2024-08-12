package net.w3resource.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import net.util.HiUtilery;

/*
 * wikipage id: wiki_autostudy_java_arraylist 
 */
public class LstBundle01 {
    final int MAX = 25;
    HiUtilery util = new HiUtilery();

    public void convertingArray2List() {
        String[] guys = {"Ruben", "Fredy", "Pablo"};
        List<String> list = null;
        list = Arrays.asList(guys);
        System.out.println(list);
    }

    public void convertingArrayList2HashSet() {
        String[] array = new String[MAX];

        // generating random strings
        for(int i=0; i<array.length; i++)
            array[i] = util.generateRandomString(5);

        // sorting array
        for(int i=0; i<array.length; i++) {
            for(int j=i+1; j<array.length; j++) {
                if(array[j].compareTo(array[i])<0) {
                    String tmp = array[j];
                    array[j]=array[i];
                    array[i]=tmp;
                }
            }
        }
        System.out.println("Original array content: " + Arrays.toString(array));

        // 1. Converting to Arraylist using Arrays util
        List<String> list = Arrays.asList(array);
        List<String> list1 = new ArrayList<>(Arrays.asList(array));
        List<String> list2 = new ArrayList<>();

        Arrays.asList(array).forEach(list2::add);
        List<String> list3 = Arrays.stream(array).collect(Collectors.toList());
        
        System.out.println("\n1. Converting to Arraylist using Arrays util: " + list);
        System.out.println("\n2. Converting to ArrayList using Constructor: " + list1);
        System.out.println("\n3. Converting to ArrayList using Add(): " + list2);
        System.out.println("\n4. Converting to ArrayList using Streams: " + list3);
    }

    public void findingNumElementsinArrayList() {
        List<String> list = new ArrayList<>();
        List<String> lcontainA = new ArrayList<>();
        for(int i=0; i<30; i++) 
            list.add(util.generateRandomString(10));
        list.forEach(name -> { 
            if(name.contains("A")) 
                lcontainA.add(name);
            });
        System.out.printf("ContainingA size: %d, content:%s\n", lcontainA.size(), lcontainA);
        System.out.println("Size of ArrayList: " + list.size());       
    }

    public void gettingSubListFromArrayList() {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        List<Character> clist = new ArrayList<>();
        List<Character> clower = new ArrayList<>();
        for(int i=0; i<alphabet.length(); i++) 
            clist.add(Character.valueOf(alphabet.charAt(i)));
        clist.forEach(x->{
            if(Character.isLowerCase(x)) {
                clower.add(x);
            }
        });
        System.out.println("Lowers list:"+clower);
    }

    public void removingDuplicatesFromArrayList() {
        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i=1; i<100; i++) 
            list.add(rand.nextInt(0,10));

        // 1st method usig for
        for(int i=0; i<list.size(); i++) {
            boolean located = false;
            Integer toSearch = list.get(i);

            for(int j=0; j<list1.size(); j++) 
                if(toSearch==list1.get(j)) 
                    located = true;

            if(!located) list1.add(toSearch);
        }
        
        // 2nd method using unnamed function (arrow)
        list.forEach(x->{
            if(!list2.contains(x)) {
                list2.add(x);
            }
        });

        // 3rd method using Set
        Set<Integer> set = new LinkedHashSet<>();
        set.addAll(list);

        // 4th method using Streams
        System.out.println("Original List: " + list);
        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);
        System.out.println("Set " + set);
        System.out.print("Streams: [");
        list.stream().distinct().collect(Collectors.toList()).forEach(x->{
            System.out.print(x+", ");
        });
        System.out.println("]");
    }

    public void convertingArrayList2Array() {
        HiUtilery util = new HiUtilery();
        List<String> list = new ArrayList<>();
        for(int i=0; i<200; i++) 
            list.add(util.generateRandomString(5));
        String[] res = new String[list.size()];
        for(int i=0; i<res.length; i++)
            res[i]= list.get(i);
        System.out.println(Arrays.toString(res));
    }

    public void insertingRemovingElementInArray() {
        List<String> list = new ArrayList<>();
        for(int i=0; i<10; i++)        
            list.add(util.generateRandomString(4));
        System.out.println("Origina ArrayList: " + list );
        list.add(1,"Fredy Hernandez");

        System.out.println("Inserting 'Fredy Hernandez' Element: " + list);

        list.remove(0);
        System.out.println("Removing Element in 0 position" + list);

        list.remove("Fredy Hernandez");
        System.out.println("Removing 'Fredy Hernandez' Element by value: " + list);

        List<String> toinsert = new ArrayList<String>(Arrays.asList("uno","dos","tres"));
        list.addAll(0,toinsert);
        System.out.println("Adding sublist in 0 posicion: " + list);

        System.out.println("Printing sublist: ");
        list.subList(0, 5).forEach(x->System.out.println(x));

        list.set(0, "Ruben Murga Tapia");
        System.out.println("Printing replace in 0 position : ");
        list.stream().forEach(System.out::println);

        System.out.println("Contains [Ruben Murga Tapia] ?: " + list.contains("Ruben Murga Tapia"));

        list.clear();
        System.out.println("Clear Element, List: " + list);
    }

    public static void main(String[] args) {
        LstBundle01 app = new LstBundle01();
        Scanner sn = new Scanner(System.in);
        System.out.println("LIST's Bundle 01 MENU");
        System.out.println("1. Converting an Array to List");
        System.out.println("2. Converting an Array to HashSet");
        System.out.println("3. Finding number of elements in ArrayList");
        System.out.println("4. Getting SubList from ArrayList");
        System.out.println("5. Removing Duplicates from ArrayList");
        System.out.println("6. Converting an ArrayList to Array");
        System.out.println("7. Inserting+Removing in ArrayList");

        int option = sn.nextInt();
        switch (option) {
            case 1 -> app.convertingArray2List();
            case 2 -> app.convertingArrayList2HashSet();
            case 3 -> app.findingNumElementsinArrayList();
            case 4 -> app.gettingSubListFromArrayList();
            case 5 -> app.removingDuplicatesFromArrayList();
            case 6 -> app.convertingArrayList2Array();
            case 7 -> app.insertingRemovingElementInArray();
            default -> System.out.println("OPTION NOT RECOGNIZED");

        }
        sn.close();
    }
    
}
