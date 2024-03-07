package com.patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Aggregate - Library book collection
 */
public class Library implements BookCollection {
    private List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public BookIterator createIterator() {
        return new LibraryIterator(books);
    }

    @Override
    public int getCount() {
        return books.size();
    }

    /**
     * Concrete Iterator - Internal class for traversing books
     */
    private static class LibraryIterator implements BookIterator {
        private List<Book> books;
        private int position = 0;

        public LibraryIterator(List<Book> books) {
            this.books = books;
        }

        @Override
        public boolean hasNext() {
            return position < books.size();
        }

        @Override
        public Book next() {
            if (hasNext()) {
                return books.get(position++);
            }
            return null;
        }

        @Override
        public boolean hasPrevious() {
            return position > 0;
        }

        @Override
        public Book previous() {
            if (hasPrevious()) {
                return books.get(--position);
            }
            return null;
        }

        @Override
        public void reset() {
            position = 0;
        }
    }
}
