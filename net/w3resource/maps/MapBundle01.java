package net.w3resource.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import net.util.HiUtilery;

public class MapBundle01 {
    HiUtilery util = new HiUtilery();

    public void insertingEntries2Map() {
        Map<Integer, String> map = new HashMap<>();
        for(int i=0; i<100; i++) {
            map.put(util.generateRandom(1, 1000),util.generateRandomString(2));
        }
        System.out.println("Printing original Map:");
        for(Map.Entry<Integer,String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        MapBundle01 app = new MapBundle01();
        System.out.println("MAIN MENU");
        System.out.println("1. Inserting Entries to Map");
        int option = sn.nextInt();
        switch (option) {
            case 1-> app.insertingEntries2Map();
            case 2-> System.out.println("PENDING");
            default -> System.out.println("Option to allowed");
        }


    }
    
}
