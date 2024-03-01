package com.patterns.behavioral.command;

/**
 * Command Interface - Declares execute method
 */
public interface Command {
    void execute();
    void undo();
}
