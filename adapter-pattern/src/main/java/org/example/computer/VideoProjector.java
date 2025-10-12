package org.example.computer;

public class VideoProjector implements VGA {
    @Override
    public void print(String message) {
        System.out.println("...Projector...");
        System.out.println(message);
        System.out.println("...Projector...");
    }
}
