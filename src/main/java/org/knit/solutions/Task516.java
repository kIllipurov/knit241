package org.knit.solutions;
import org.knit.TaskDescription;
import org.knit.solutions.lab5.task516.*;

@TaskDescription(taskNumber = 516, taskDescription = "5.16 Текст + (Flyweight)")
public class Task516 implements Solution {
    @Override
    public void execute() {
        CharacterFactory factory = new CharacterFactory();

        String text = "HELLO FLYWEIGHT";
        int x = 0;

        for (char ch : text.toCharArray()) {
            if (ch == ' ') {
                x += 1; // просто сдвиг для пробела
                continue;
            }
            CharacterFlyweight character = factory.getCharacter(ch);
            String style = "Bold"; // внешнее состояние
            character.render(x, 0, style);
            x += 1;
        }

        System.out.println("\nTotal flyweight objects created: " + factory.getTotalCharacters());
    }
}