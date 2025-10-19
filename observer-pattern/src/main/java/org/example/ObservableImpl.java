package org.example;

import java.util.ArrayList;
import java.util.List;

public class ObservableImpl implements Observable{
    private List<Observer> observers = new ArrayList<>();
    private int state = 3;
    @Override
    public void subscribe(Observer obs) {
        this.observers.add(obs);
    }

    @Override
    public void unsubscribe(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObserver(Observer obs) {
        for(Observer observer: observers){
            observer.update(this.state);
        }
    }

    @Override
    public void notifyAllObservers(){
        for(Observer observer: observers){
            observer.update(this.state);
        }
    }

}
