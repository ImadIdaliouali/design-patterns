package org.example;

public class Expresso extends Boisson{
    protected String description = "boisson Expresso ";

    @Override
    public double cout() {
        return 10;
    }

    @Override
    public String getDescription(){
        return description;
    }

}
