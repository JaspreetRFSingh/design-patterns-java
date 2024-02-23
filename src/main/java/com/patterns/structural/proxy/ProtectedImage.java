package com.patterns.structural.proxy;

/**
 * Protection Proxy - Controls access based on user role
 */
public class ProtectedImage implements Image {
    private RealImage realImage;
    private String fileName;
    private String requiredRole;

    public ProtectedImage(String fileName, String requiredRole) {
        this.fileName = fileName;
        this.requiredRole = requiredRole;
    }

    @Override
    public void display(String userRole) {
        if (hasAccess(userRole)) {
            if (realImage == null) {
                realImage = new RealImage(fileName);
            }
            realImage.display();
        } else {
            System.out.println("Access denied! Required role: " + requiredRole);
        }
    }

    private boolean hasAccess(String userRole) {
        return "admin".equals(userRole) || requiredRole.equals(userRole);
    }

    @Override
    public void display() {
        display("guest"); // Default to guest
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}
