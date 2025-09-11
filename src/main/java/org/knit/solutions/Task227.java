package org.knit.solutions;
import org.knit.TaskDescription;
import org.knit.solutions.lab2.task27.*;

@TaskDescription(taskNumber = 227, taskDescription = "2.7 Производитель-Потребитель с ограничением")
public class Task227 implements Solution {
    @Override
    public void execute() {
        Storage storage = new Storage();

        Maker maker = new Maker(storage);
        User user = new User(storage);

        maker.start();
        user.start();
    }
}