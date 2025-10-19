package org.example;

public class Chocolat extends Decorator{
    public Chocolat(Boisson boisson){
        super(boisson);
    }

    @Override
    public double cout() {
        return 2 + boisson.cout();
    }

    @Override
    public String getDescription(){
        return boisson.getDescription() +"au chocolat ";
    }

}
