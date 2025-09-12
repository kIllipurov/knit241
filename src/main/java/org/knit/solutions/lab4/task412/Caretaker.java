package org.knit.solutions.lab4.task412;
import java.util.Stack;

public class Caretaker {
    private Stack<Memento> history = new Stack<>();

    public void save(TextEditor editor) {
        history.push(editor.saveState());
    }

    public void undo(TextEditor editor) {
        if (!history.isEmpty()) {
            Memento memento = history.pop();
            editor.restoreState(memento);
        } else {
            System.out.println("Нет сохранённых состояний для отката!");
        }
    }
}
