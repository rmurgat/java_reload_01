package net.w3resource.sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.Vector;
import java.util.stream.Collectors;

import net.util.HiUtilery;

/**
 * HASHSET 
 * wiki id: [wiki_autostudy_java_hashset]
 */
public class SetBundle01 {
    HiUtilery util = new HiUtilery();

    public void insertingValues2Set() {
        Set<String> set = new HashSet<String>();
        Set<String> set1 = new HashSet<String>();
        set.addAll(new ArrayList<>(Arrays.asList(new String[]{"Tushar","Manoj","Yadav", "Hitesh", "Advin"})));
        set1.addAll(new ArrayList<>(Arrays.asList(new String[]{"Ruben","Fredy","Ernesto","Federico","Carlos","Juan"}))); 

        List<String> list = set.stream().collect(Collectors.toList());
        list.add("Ruben");
        list.add("Fredy");

        set1.addAll(list);
        set1.stream().filter(x->containChar(x)).forEach(System.out::println);
    }

    public boolean containChar(String str) {
        for(int i=0; i<str.length(); i++) {
            if("ABCR".indexOf(str.charAt(i))>-1) return true;
        }
        return false;
    }

    public void convertingSet2() {
        Set<String> set = new HashSet<>();
        List<String> res = new LinkedList<>();
        set.addAll(Arrays.asList(new String[]{"Acapulco","Chilpancingo","Cuernavaca","Miguel Hidalgo","Cuajimalpa","Coyoacan"}));

        System.out.println("Converting a HashSet to ArrayList:");
        List<String> list = new ArrayList<>();
        list.addAll(set);
        list.forEach(System.out::println);

        System.out.println("Converting a HashSet to Vector:");
        List<String> vector = new Vector<>();
        vector.addAll(set);
        vector.stream().distinct().forEach(res::add);

        System.out.println("Result to Vector:");
        System.out.println(res);

        System.out.println("Converting a HashSet to TreeSet:");
        Set<String> tree = new TreeSet<>();
        tree.addAll(vector);
        tree.stream().forEach(System.out::println);

        System.out.println("Converting a HashSet to Array:");
        String[] array = new String[set.size()];
        set.toArray(array);
        Arrays.stream(array).forEach(System.out::println);
    }

    public void removingValues() {
        Scanner sn = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        sn.useDelimiter("\n");
        for(int i=0; i<100; i++)
            set.add(util.generateRandomString(1));
        System.out.println("Printing original Set size: [" + set.size() + "]");
        set.forEach(x->System.out.printf("%s, ", x));
        System.out.println("\nType the value to find and remove:");
        String tofind = sn.next();
        set.remove(tofind);
        System.out.println("End Set size: [" + set.size() + "]");
        set.forEach(x->System.out.printf("%s, ", x));
        sn.close();
    }  
    
    public void unionbetween2() {
        Set<String> mexicans = new HashSet<>();
        Set<String> indians = new HashSet<>();
        Set<String> res = new HashSet<>();
        mexicans.addAll(Arrays.asList("ruben","fredy","juan","pedro","ernesto"));
        indians.addAll(Arrays.asList("suresh","yadav","tushar","manoj","ruben"));
        res.addAll(mexicans); res.addAll(indians);
        System.out.println("Original Set:");
        res.forEach(System.out::println);
        System.out.println("Set coincidences:");
        Set<String> coinSet = res.stream().filter(x->mexicans.contains(x)&&indians.contains(x)).collect(Collectors.toSet());
        Spliterator<String> it = coinSet.spliterator();
        it.forEachRemaining(System.out::println);
            
    }

    public static void main(String[] pars) {
        SetBundle01 app = new SetBundle01();
        Scanner sn = new Scanner(System.in);

        System.out.println("MAIN MENU");
        System.out.println("1. Inserting values in HashSet");
        System.out.println("2. Converting Set values to ...");
        System.out.println("3. Removing values in HashSet");
        System.out.println("4. Union between two HashSets");
        System.out.println("Which option to Execute?");
        int option = sn.nextInt();
        switch (option) {
            case 1 -> app.insertingValues2Set();
            case 2 -> app.convertingSet2();
            case 3 -> app.removingValues();
            case 4 -> app.unionbetween2();
            default -> System.out.println("Option not allowed");
                
        } 
        sn.close();
    }
    
}
