package com.patterns.structural.bridge;

/**
 * Concrete Implementor - TV Device
 */
public class TV implements Device {
    private boolean isOn = false;
    private int volume = 50;
    private int channel = 1;

    @Override
    public void turnOn() {
        System.out.println("TV is now ON");
        isOn = true;
    }

    @Override
    public void turnOff() {
        System.out.println("TV is now OFF");
        isOn = false;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(100, volume));
        System.out.println("TV volume set to " + this.volume);
    }

    @Override
    public int getVolume() {
        return volume;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("TV channel set to " + channel);
    }

    public boolean isOn() {
        return isOn;
    }
}
