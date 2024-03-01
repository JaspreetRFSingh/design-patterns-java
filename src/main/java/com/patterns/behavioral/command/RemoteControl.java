package com.patterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Invoker - Remote control that executes commands
 */
public class RemoteControl {
    private List<Command> commands = new ArrayList<>();
    private Stack<Command> history = new Stack<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void pressButton(int slot) {
        if (slot >= 0 && slot < commands.size()) {
            Command command = commands.get(slot);
            command.execute();
            history.push(command);
        }
    }

    public void pressUndo() {
        if (!history.isEmpty()) {
            Command command = history.pop();
            System.out.print("Undoing: ");
            command.undo();
        } else {
            System.out.println("Nothing to undo");
        }
    }

    public void clearCommands() {
        commands.clear();
    }
}
