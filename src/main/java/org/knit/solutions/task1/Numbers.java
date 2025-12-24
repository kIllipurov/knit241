package org.knit.solutions.task1;

public class Numbers {
    public void execute() {
        String line = "";
        int counter = 1;

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                line = line + counter;
                if (i < 9) {
                    line = line + ", ";
                }
                counter++;
            }
            line = line + "\n"; // Добавляем перевод строки после каждой "строки"
        }
        System.out.println(line);
    }
}