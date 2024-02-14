package com.patterns.structural.facade;

/**
 * Demo class for Facade Pattern
 */
public class FacadeDemo {
    public static void main(String[] args) {
        System.out.println("=== Facade Pattern Demo ===\n");

        // Client uses simple facade interface
        ComputerFacade computer = new ComputerFacade();
        
        System.out.println("Using Facade:");
        computer.start();
        computer.shutdown();

        System.out.println("Without Facade (client manages subsystems):");
        // Without facade, client would need to:
        CPU cpu = new CPU();
        Memory memory = new Memory();
        HardDrive hd = new HardDrive();
        
        cpu.freeze();
        memory.load(hd.getBootSector(), hd.read(hd.getBootSector(), hd.getSectorSize()));
        cpu.jump(0);
        cpu.execute();
    }
}
