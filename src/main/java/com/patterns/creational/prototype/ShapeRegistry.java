package com.patterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Prototype Registry - Manages and provides prototype instances
 */
public class ShapeRegistry {
    private Map<String, Shape> shapeCache = new HashMap<>();

    public ShapeRegistry() {
        // Initialize with default prototypes
        Circle circle = new Circle(0, 0, 10, "red");
        shapeCache.put("Circle", circle);

        Rectangle rectangle = new Rectangle(0, 0, 20, 30, "blue");
        shapeCache.put("Rectangle", rectangle);
    }

    public Shape getShape(String type) {
        Shape prototype = shapeCache.get(type);
        if (prototype != null) {
            return prototype.clone();
        }
        return null;
    }

    public void addShape(String key, Shape shape) {
        shapeCache.put(key, shape);
    }

    public void clearCache() {
        shapeCache.clear();
    }
}
