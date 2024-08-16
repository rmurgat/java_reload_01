package net.w3resource.maps;

import java.util.Scanner;

public class MapsBundle01 {

    public void option() {
        s
    }
    public void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        MapsBundle01 app = new MapsBundle01();
        System.out.println("MAIN MENU");
        System.out.println("1. Option 1");
        int option = sn.nextInt();
        switch (option) {
            case 1-> app.option();
            case 2-> app.option();
            default -> System.out.println("Option to allowed");
        }


    }
    
}
