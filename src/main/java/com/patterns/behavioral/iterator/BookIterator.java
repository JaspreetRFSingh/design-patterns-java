package com.patterns.behavioral.iterator;

import java.util.Iterator;

/**
 * Iterator Interface - For traversing collection elements
 */
public interface BookIterator extends Iterator<Book> {
    boolean hasPrevious();
    Book previous();
    void reset();
}
