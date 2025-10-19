package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Service service = new Proxy();
        Client c = new Client(service);
        c.doWork();
        c.doWork();
        c.doWork();
        c.doWork();
    }
}
