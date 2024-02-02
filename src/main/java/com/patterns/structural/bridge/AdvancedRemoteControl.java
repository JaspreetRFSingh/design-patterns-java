package com.patterns.structural.bridge;

/**
 * Refined Abstraction - Advanced Remote Control
 */
public class AdvancedRemoteControl extends RemoteControl {
    public AdvancedRemoteControl(Device device) {
        super(device);
    }

    public void setChannel(int channel) {
        if (device instanceof TV) {
            ((TV) device).setChannel(channel);
        }
    }

    public void setFrequency(double frequency) {
        if (device instanceof Radio) {
            ((Radio) device).setFrequency(frequency);
        }
    }

    public void printStatus() {
        System.out.println("Device is " + (device.isOn() ? "ON" : "OFF"));
        System.out.println("Volume: " + device.getVolume());
        if (device instanceof TV) {
            System.out.println("Channel: " + ((TV) device).getChannel());
        } else if (device instanceof Radio) {
            System.out.println("Frequency: " + ((Radio) device).getFrequency() + " MHz");
        }
    }
}
