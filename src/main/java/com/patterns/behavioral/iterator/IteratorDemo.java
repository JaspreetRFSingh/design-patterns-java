package com.patterns.behavioral.iterator;

/**
 * Demo class for Iterator Pattern
 */
public class IteratorDemo {
    public static void main(String[] args) {
        System.out.println("=== Iterator Pattern Demo ===\n");

        // Create library collection
        Library library = new Library();
        library.addBook(new Book("Design Patterns", "Gang of Four", 1994));
        library.addBook(new Book("Clean Code", "Robert C. Martin", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", 2018));
        library.addBook(new Book("Refactoring", "Martin Fowler", 2018));
        library.addBook(new Book("The Pragmatic Programmer", "Andrew Hunt", 1999));

        System.out.println("Library has " + library.getCount() + " books\n");

        // Forward iteration
        System.out.println("=== Forward Iteration ===");
        BookIterator iterator = library.createIterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println("  " + book);
        }

        // Backward iteration
        System.out.println("\n=== Backward Iteration ===");
        while (iterator.hasPrevious()) {
            Book book = iterator.previous();
            System.out.println("  " + book);
        }

        // Reset and iterate again
        System.out.println("\n=== After Reset ===");
        iterator.reset();
        if (iterator.hasNext()) {
            System.out.println("First book: " + iterator.next());
        }
    }
}
