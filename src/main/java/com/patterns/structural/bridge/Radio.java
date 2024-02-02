package com.patterns.structural.bridge;

/**
 * Concrete Implementor - Radio Device
 */
public class Radio implements Device {
    private boolean isOn = false;
    private int volume = 30;
    private double frequency = 98.5;

    @Override
    public void turnOn() {
        System.out.println("Radio is now ON");
        isOn = true;
    }

    @Override
    public void turnOff() {
        System.out.println("Radio is now OFF");
        isOn = false;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(100, volume));
        System.out.println("Radio volume set to " + this.volume);
    }

    @Override
    public int getVolume() {
        return volume;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
        System.out.println("Radio frequency set to " + frequency + " MHz");
    }

    public boolean isOn() {
        return isOn;
    }
}
