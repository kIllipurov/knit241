package org.knit.solutions.lab21.task21;

public class Complaint {
    private String description;
    private int difficulty;

    public Complaint(String description, int difficulty) {
        this.description = description;
        this.difficulty = difficulty;
    }

    public String getDescription() {
        return description;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
