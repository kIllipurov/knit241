package org.knit.solutions.lab4.task413;
import java.util.Stack;

public class RemoteControl {
    private final Stack<Command> history = new Stack<>();

    public void pressButton(Command command) {
        command.execute();
        history.push(command);
    }

    public void undoLast() {
        if (!history.isEmpty()) {
            Command lastCommand = history.pop();
            System.out.print("Undoing: ");
            lastCommand.undo();
        }
    }
}