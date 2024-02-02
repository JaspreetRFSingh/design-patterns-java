package com.patterns.structural.bridge;

/**
 * Demo class for Bridge Pattern
 */
public class BridgeDemo {
    public static void main(String[] args) {
        System.out.println("=== Bridge Pattern Demo ===\n");

        // Create devices
        Device tv = new TV();
        Device radio = new Radio();

        // Create remotes with different devices
        RemoteControl tvRemote = new RemoteControl(tv);
        AdvancedRemoteControl radioRemote = new AdvancedRemoteControl(radio);

        // Control TV
        System.out.println("Controlling TV:");
        tvRemote.togglePower();
        tvRemote.volumeUp();
        tvRemote.volumeUp();

        System.out.println("\nControlling Radio with Advanced Remote:");
        radioRemote.togglePower();
        radioRemote.volumeDown();
        radioRemote.setFrequency(101.5);
        radioRemote.printStatus();

        System.out.println("\nMuting TV:");
        tvRemote.mute();
    }
}
