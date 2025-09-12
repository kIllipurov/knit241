package org.knit.solutions;
import org.knit.solutions.lab4.task411.*;
import org.knit.TaskDescription;

@TaskDescription(taskNumber = 411, taskDescription = "4.11 Акции (Observer)")
public class Task411 implements Solution {
    @Override
    public void execute() {
        Stock tesla = new Stock("Tesla", 700.0);

        MobileApp mobileUser = new MobileApp("Kostya");
        EmailNotifier emailUser = new EmailNotifier("kostya@example.com");

        tesla.subscribe(mobileUser);
        tesla.subscribe(emailUser);

        // Цена меняется
        tesla.setPrice(710.0);
        tesla.setPrice(720.0);

        // Один пользователь отписался
        tesla.unsubscribe(emailUser);
        tesla.setPrice(730.0);
    }
}
