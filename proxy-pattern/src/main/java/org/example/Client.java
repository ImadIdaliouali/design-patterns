package org.example;

public class Client {
    private Service service;

    public Client(Service service) {
        this.service = service;
    }

    public void doWork() {
        service.calculate(12);
    }
}
