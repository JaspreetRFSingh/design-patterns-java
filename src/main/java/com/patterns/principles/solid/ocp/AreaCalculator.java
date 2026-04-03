package com.patterns.principles.solid.ocp;

import java.util.List;

/**
 * Closed for modification — this class never changes when a new shape is added.
 * Open for extension — new shapes implement Shape and plug straight in.
 */
public class AreaCalculator {

    public double totalArea(List<Shape> shapes) {
        return shapes.stream().mapToDouble(Shape::area).sum();
    }
}
