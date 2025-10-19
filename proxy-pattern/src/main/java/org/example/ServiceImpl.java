package org.example;

public class ServiceImpl implements Service{
    @Override
    public double calculate(int n){
        System.out.println("calculating ........");
        return n/10;
    }
}
