package org.example.computer;

public class HdmiVgaAdapter implements VGA {
    protected HDMI hdmi;

    public HdmiVgaAdapter(HDMI hdmi){
        this.hdmi = hdmi;
    }

    @Override
    public void print(String message) {
        hdmi.show(message.getBytes());
    }
}
