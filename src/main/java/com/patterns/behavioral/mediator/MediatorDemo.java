package com.patterns.behavioral.mediator;

/**
 * Demo class for Mediator Pattern
 */
public class MediatorDemo {
    public static void main(String[] args) {
        System.out.println("=== Mediator Pattern Demo ===\n");

        // Create chat room (mediator)
        ChatRoom chatRoom = new ChatRoom();

        // Create users
        User alice = new ChatUser(chatRoom, "Alice");
        User bob = new ChatUser(chatRoom, "Bob");
        User charlie = new ChatUser(chatRoom, "Charlie");
        User admin = new AdminUser(chatRoom, "Admin");

        // Add users to chat room
        chatRoom.addUser(alice);
        chatRoom.addUser(bob);
        chatRoom.addUser(charlie);
        chatRoom.addUser(admin);

        System.out.println("--- Public Messages ---");
        alice.sendMessage("Hello everyone!");
        bob.sendMessage("Hi Alice!");
        charlie.sendMessage("Hey there!");

        System.out.println("\n--- Admin Broadcast ---");
        admin.sendMessage("Server maintenance at midnight!");

        System.out.println("\n--- Private Message ---");
        ((AdminUser) admin).sendPrivateMessage("Please review the logs", alice);
    }
}
