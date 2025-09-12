package org.knit.solutions.lab4.task412;

public class TextEditor {
    private String text = "";

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    // Создание снимка состояния
    public Memento saveState() {
        return new Memento(text);
    }

    // Восстановление состояния
    public void restoreState(Memento memento) {
        text = memento.getState();
    }
}
