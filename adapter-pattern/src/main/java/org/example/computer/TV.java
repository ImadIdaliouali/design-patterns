package org.example.computer;

public class TV implements HDMI {
    @Override
    public void show(byte[] message) {
        System.out.println("---TV---");
        System.out.println(new String(message));
        System.out.println("---TV---");
    }
}
