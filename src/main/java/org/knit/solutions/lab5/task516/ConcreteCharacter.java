package org.knit.solutions.lab5.task516;

public class ConcreteCharacter implements CharacterFlyweight {
    private final char c; // внутреннее состояние, уникальное для символа

    public ConcreteCharacter(char c) {
        this.c = c;
    }

    @Override
    public void render(int x, int y, String style) {
        System.out.println("Rendering '" + c + "' at (" + x + "," + y + ") with style: " + style);
    }
}