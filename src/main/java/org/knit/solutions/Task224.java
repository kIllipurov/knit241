package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab2.Car;
import org.knit.solutions.lab2.GasStation;

@TaskDescription(taskNumber = 224, taskDescription = "2.4 Автозаправочная станция (wait/notify)")
public class Task224 implements Solution {
    @Override
    public void execute() {
        GasStation station = new GasStation();

        Car car1 = new Car("Машина-1", station);
        Car car2 = new Car("Машина-2", station);
        Car car3 = new Car("Машина-3", station);
        Car car4 = new Car("Машина-4", station);

        car1.start();
        car2.start();
        car3.start();
        car4.start();

        try {
            car1.join();
            car2.join();
            car3.join();
            car4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
