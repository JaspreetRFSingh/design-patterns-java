package com.patterns.behavioral.iterator;

/**
 * Aggregate Interface - Collection that can create iterators
 */
public interface BookCollection {
    BookIterator createIterator();
    void addBook(Book book);
    int getCount();
}
