package com.patterns.behavioral.command;

/**
 * Demo class for Command Pattern
 */
public class CommandDemo {
    public static void main(String[] args) {
        System.out.println("=== Command Pattern Demo ===\n");

        // Create receivers
        Light livingRoomLight = new Light("Living Room");
        Light bedroomLight = new Light("Bedroom");
        TV tv = new TV();

        // Create commands
        Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff = new LightOffCommand(livingRoomLight);
        Command bedroomLightOn = new LightOnCommand(bedroomLight);
        Command tvOn = new TVOnCommand(tv);
        Command tvOff = new TVOffCommand(tv);

        // Configure remote control
        RemoteControl remote = new RemoteControl();
        remote.addCommand(livingRoomLightOn);    // Slot 0
        remote.addCommand(livingRoomLightOff);   // Slot 1
        remote.addCommand(bedroomLightOn);       // Slot 2
        remote.addCommand(tvOn);                 // Slot 3
        remote.addCommand(tvOff);                // Slot 4

        // Use remote
        System.out.println("Pressing button 0 (Living Room Light On):");
        remote.pressButton(0);

        System.out.println("\nPressing button 3 (TV On):");
        remote.pressButton(3);

        System.out.println("\nPressing button 2 (Bedroom Light On):");
        remote.pressButton(2);

        System.out.println("\n=== Undo Operations ===");
        remote.pressUndo(); // Undo bedroom light
        remote.pressUndo(); // Undo TV
        remote.pressUndo(); // Undo living room light
        remote.pressUndo(); // Nothing to undo
    }
}
