package com.patterns.structural.proxy;

/**
 * Demo class for Proxy Pattern
 */
public class ProxyDemo {
    public static void main(String[] args) {
        System.out.println("=== Proxy Pattern Demo ===\n");

        // Virtual Proxy - Lazy Loading
        System.out.println("--- Virtual Proxy (Lazy Loading) ---");
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        System.out.println("\nImages created but not loaded yet...");
        System.out.println("Image 1 filename: " + image1.getFileName());
        System.out.println("Image 2 filename: " + image2.getFileName());

        System.out.println("\nNow displaying image1 (triggers loading):");
        image1.display();

        System.out.println("\nDisplaying image1 again (uses cached):");
        image1.display();

        System.out.println("\nNow displaying image2 (triggers loading):");
        image2.display();

        // Protection Proxy
        System.out.println("\n\n--- Protection Proxy (Access Control) ---");
        Image protectedImage = new ProtectedImage("secret.jpg", "admin");
        
        System.out.println("\nGuest trying to access:");
        protectedImage.display("guest");
        
        System.out.println("\nAdmin trying to access:");
        protectedImage.display("admin");
    }
}
