package com.patterns.structural.facade;

/**
 * Facade - Simplified interface to computer subsystems
 */
public class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    /**
     * Single method to start the computer - hides complexity
     */
    public void start() {
        System.out.println("=== Starting Computer ===");
        cpu.freeze();
        memory.load(hardDrive.getBootSector(), hardDrive.read(hardDrive.getBootSector(), hardDrive.getSectorSize()));
        cpu.jump(0);
        cpu.execute();
        System.out.println("=== Computer Started ===\n");
    }

    /**
     * Single method to shutdown the computer
     */
    public void shutdown() {
        System.out.println("=== Shutting Down Computer ===");
        cpu.freeze();
        memory.free();
        System.out.println("=== Computer Shutdown ===\n");
    }
}
