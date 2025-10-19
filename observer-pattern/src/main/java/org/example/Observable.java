package org.example;

public interface Observable {
    void subscribe(Observer obs);
    void unsubscribe(Observer obs);
    void notifyObserver(Observer obs);
    void notifyAllObservers();
}
