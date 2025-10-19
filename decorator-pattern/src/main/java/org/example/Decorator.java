package org.example;

public abstract class Decorator extends Boisson{
    protected Boisson boisson;

    public Decorator(Boisson boisson){
        this.boisson = boisson;
    }

    @Override
    public abstract String getDescription();

}
