package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab4.task412.*;

@TaskDescription(taskNumber = 412, taskDescription = "4.12 Текст (Memento)")
public class Task412 implements Solution {
    @Override
    public void execute() {
        TextEditor editor = new TextEditor();
        Caretaker caretaker = new Caretaker();

        editor.setText("Hello, world!");
        caretaker.save(editor); // сохраняем текущее состояние

        editor.setText(editor.getText() + " How are you?");
        System.out.println("Текущий текст: " + editor.getText());

        caretaker.undo(editor); // откат
        System.out.println("После undo: " + editor.getText());

        // Добавим ещё несколько уровней
        editor.setText(editor.getText() + " I'm fine.");
        caretaker.save(editor);
        editor.setText(editor.getText() + " Thanks!");
        System.out.println("Текущий текст: " + editor.getText());

        caretaker.undo(editor);
        System.out.println("После второго undo: " + editor.getText());
    }
}
