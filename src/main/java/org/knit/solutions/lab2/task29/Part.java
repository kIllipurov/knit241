package org.knit.solutions.lab2.task29;
// деталь
// тут номер детали
// статус детали
public class Part {
    private final int id;
    private boolean assembled;
    private boolean checked;

    public Part(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAssembled(boolean assembled) {
        this.assembled = assembled;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "Деталь " + id;
    }
}