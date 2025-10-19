package org.example;

public class Sumatra extends Boisson{
    protected String description = "sumatra";

    @Override
    public double cout() {
        return 15;
    }

    @Override
    public String getDescription(){
        return description;
    }
}
