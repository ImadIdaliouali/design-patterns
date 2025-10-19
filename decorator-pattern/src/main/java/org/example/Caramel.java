package org.example;

public class Caramel extends Decorator{
    public Caramel(Boisson boisson) {
        super(boisson);
    }

    @Override
    public String getDescription() {
        return boisson.getDescription() + " au caramel ";
    }

    @Override
    public double cout() {
        return 3 + boisson.cout();
    }
}
