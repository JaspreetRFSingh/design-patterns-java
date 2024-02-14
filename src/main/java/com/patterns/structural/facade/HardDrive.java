package com.patterns.structural.facade;

/**
 * Subsystem - Hard Drive component
 */
public class HardDrive {
    private static final long BOOT_SECTOR = 0;
    private static final int SECTOR_SIZE = 512;

    public byte[] read(long lba, int size) {
        System.out.println("HardDrive: Reading sector " + lba);
        return new byte[size];
    }

    public long getBootSector() {
        return BOOT_SECTOR;
    }

    public int getSectorSize() {
        return SECTOR_SIZE;
    }
}
