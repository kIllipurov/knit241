package org.knit.solutions.lab5.task516;
import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    private final Map<Character, CharacterFlyweight> pool = new HashMap<>();

    public CharacterFlyweight getCharacter(char c) {
        pool.putIfAbsent(c, new ConcreteCharacter(c));
        return pool.get(c);
    }

    public int getTotalCharacters() {
        return pool.size(); // сколько объектов реально создано
    }
}