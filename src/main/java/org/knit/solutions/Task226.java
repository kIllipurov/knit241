package org.knit.solutions;
import org.knit.TaskDescription;
import org.knit.solutions.lab2.task26.*;

@TaskDescription(taskNumber = 226, taskDescription = "2.6 Переезд: Ресторан и Машины (wait/notify)")
public class Task226 implements Solution {
    @Override
    public void execute() {
        Crossing crossing = new Crossing();

        // Фиксированное количество машин
        for (int i = 1; i <= 5; i++) {
            new Car(crossing, "Машина " + i).start();
        }

        // Поезд
        new Train(crossing).start();
    }
}