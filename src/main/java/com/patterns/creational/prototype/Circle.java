package com.patterns.creational.prototype;

/**
 * Concrete Prototype - Circle
 */
public class Circle implements Shape {
    private int x;
    private int y;
    private int radius;
    private String color;

    public Circle() {
    }

    public Circle(int x, int y, int radius, String color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    // Copy constructor for cloning
    public Circle(Circle other) {
        this.x = other.x;
        this.y = other.y;
        this.radius = other.radius;
        this.color = other.color;
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle at (" + x + ", " + y + 
                          ") with radius " + radius + " in " + color);
    }

    @Override
    public String getType() {
        return "Circle";
    }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
    
    public int getRadius() { return radius; }
    public void setRadius(int radius) { this.radius = radius; }
    
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    @Override
    public String toString() {
        return "Circle{x=" + x + ", y=" + y + ", radius=" + radius + ", color='" + color + "'}";
    }
}
