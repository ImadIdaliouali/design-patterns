package org.example;

public class ObserverImpl1 implements Observer{
    private  int observerState;

    @Override
    public void update(int newState) {
        this.observerState = newState;
        System.out.println("---------- I am the observer 1, my state is updated " + observerState + "------------");
    }

}
