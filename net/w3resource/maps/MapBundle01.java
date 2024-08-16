package net.w3resource.maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Scanner;

import net.util.HiUtilery;

public class MapBundle01 {
    HiUtilery util = new HiUtilery();

    public class KeyValue {
        public String key="";
        public String value="";
        public KeyValue(String key, String value) {
            this.key=key;
            this.value=value;
        }
        public String toString() {
            return "KeyValue key:["+this.key+"], value:["+this.value+"]";
        }
    }

    public void insertingEntries2Map() {
        Map<Integer, String> map = new HashMap<>();
        for(int i=0; i<100; i++) {
            map.put(util.generateRandom(1, 1000),util.generateRandomString(2));
        }
        System.out.printf("Printing original Map keyvalues:[%d], keycontent:[%d]\n", map.keySet().size(), map.values().size());
        for(Map.Entry<Integer,String> entry: map.entrySet()) {
            System.out.printf("%d-%s, ", entry.getKey(), entry.getValue());
        }
    }

    public void copyingEntriesBetween2Maps() {

        Map<Integer, String> map = new HashMap<>();
        for(int i=0; i<100; i++)
            map.put(i+1,util.generateRandomString(2));

        System.out.println("Copying to new Array KeyValue[]");
        KeyValue[] lkv = map.entrySet().stream().filter(x->x.getValue().contains("Z")).map(x->new KeyValue(Integer.toString(x.getKey()),x.getValue())).toArray(KeyValue[]::new);
        Arrays.asList(lkv).forEach(System.out::println);

        System.out.println("Showing entries containing C as Map:");
        Map<Integer, String> res = map.entrySet().stream().filter(x->x.getValue().contains("C")).collect(Collectors.toMap(Entry::getKey, Entry::getValue));
        res.values().forEach(System.out::println);

        System.out.println("Showing entries containing A as List:");
        List<String> list = map.entrySet().stream().filter(x->x.getValue().contains("A")).map(Map.Entry::getValue).collect(Collectors.toList());

        for(String value: list) {
            System.out.printf("%s, ",value);
        }

        System.out.println("\nShowing entries containing [S] as Array");
        String[] values = new String[map.values().size()];
        values = map.values().stream().filter(x->x.contains("S")).toArray(String[]::new);
        for(int i=0; i<values.length; i++)
            System.out.printf("%s, ", values[i]);

        System.out.println("\nConversion from Array to Map");
        res.clear();
        Arrays.asList(lkv).stream().forEach(x->{
            res.put(Integer.valueOf(util.generateRandom(0, 111)), x.value);
        });
        System.out.println("\nCheck this: " + res);

        System.out.println("Clonning a Map to a new one");
        HashMap<Integer,String> origin = new HashMap<>(res);
        origin.entrySet().forEach(x -> {
            System.out.printf("%d-%s,",x.getKey(),x.getValue());
        });
    }

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        MapBundle01 app = new MapBundle01();
        System.out.println("MAIN MENU");
        System.out.println("1. Inserting entries to HashMap");
        System.out.println("2. Copying entries between 2 Maps");

        int option = sn.nextInt();
        switch (option) {
            case 1-> app.insertingEntries2Map();
            case 2-> app.copyingEntriesBetween2Maps();
            default -> System.out.println("Option to allowed");
        }


    }
    
}
