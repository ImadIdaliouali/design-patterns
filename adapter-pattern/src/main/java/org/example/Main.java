package org.example;

import org.example.computer.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        CentralUnit computer = new CentralUnit();
        computer.setVga(new Monitor());
        computer.print("Hello World");

        HDMI hdmi = new TV();
        computer.setVga(new HdmiVgaAdapter(hdmi));
        computer.print("Hello World from HDMI Adapter");
    }
}
