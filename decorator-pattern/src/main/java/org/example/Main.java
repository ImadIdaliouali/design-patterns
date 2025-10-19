package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Boisson boisson = new Expresso(); // 10
        System.out.println("---------------"+ boisson.getDescription());
        System.out.println("------------------------------------------");
        boisson = new Caramel(boisson); // 3
        System.out.println("---------------"+ boisson.getDescription());
        boisson = new Chocolat(boisson); // 2
        System.out.println("---------------"+ boisson.getDescription());
        boisson = new Chocolat(boisson);
        System.out.println("---------------"+ boisson.getDescription());

        System.out.println("cout final = "+ boisson.cout());

        // Boisson boisson2 = new Sumatra();
        // System.out.println("---------------"+ boisson2.getDescription());
        // boisson2 = new Caramel(boisson2);
        // System.out.println("---------------"+ boisson2.getDescription());
    }
}
