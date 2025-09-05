package org.knit.solutions;
import org.knit.TaskDescription;
import org.knit.solutions.lab21.task213.*;

@TaskDescription(taskNumber = 213, taskDescription = "2.3 Паттерн Factory (Каршеринг)")
public class Task213 implements Solution {
    @Override
    public void execute() {
        try {
            Transport business = TransportFactory.createTransport("business");
            System.out.println(business.getSpecifications());

            Transport family = TransportFactory.createTransport("family");
            System.out.println(family.getSpecifications());

            Transport delivery = TransportFactory.createTransport("delivery");
            System.out.println(delivery.getSpecifications());

            // Проверка ошибки
            Transport unknown = TransportFactory.createTransport("spaceship");
            System.out.println(unknown.getSpecifications());

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}