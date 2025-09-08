package org.knit.solutions;
import org.knit.TaskDescription;
import org.knit.solutions.lab2.task25.*;

@TaskDescription(taskNumber = 225, taskDescription = "2.5 Ресторан: Повар и Официант (wait/notify)")
public class Task225 implements Solution {
    @Override
    public void execute() {
        Tray tray = new Tray();

        Chef chef = new Chef(tray);
        Waiter waiter = new Waiter(tray);

        chef.start();
        waiter.start();
    }
}