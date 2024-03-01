package com.patterns.behavioral.command;

/**
 * Receiver - TV that can be turned on/off
 */
public class TV {
    private boolean isOn = false;
    private int channel = 1;
    private int volume = 50;

    public void turnOn() {
        isOn = true;
        System.out.println("TV is ON");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("TV is OFF");
    }

    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("TV channel set to " + channel);
    }

    public void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(100, volume));
        System.out.println("TV volume set to " + this.volume);
    }

    public boolean isOn() {
        return isOn;
    }
}
