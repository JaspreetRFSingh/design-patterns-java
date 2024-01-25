package com.patterns.creational.prototype;

/**
 * Concrete Prototype - Rectangle
 */
public class Rectangle implements Shape {
    private int x;
    private int y;
    private int width;
    private int height;
    private String color;

    public Rectangle() {
    }

    public Rectangle(int x, int y, int width, int height, String color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    // Copy constructor for cloning
    public Rectangle(Rectangle other) {
        this.x = other.x;
        this.y = other.y;
        this.width = other.width;
        this.height = other.height;
        this.color = other.color;
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle at (" + x + ", " + y + 
                          ") with size " + width + "x" + height + " in " + color);
    }

    @Override
    public String getType() {
        return "Rectangle";
    }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
    
    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }
    
    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }
    
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    @Override
    public String toString() {
        return "Rectangle{x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + ", color='" + color + "'}";
    }
}
