package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab21.task212.*;

@TaskDescription(taskNumber = 212, taskDescription = "Паттерн Decorator (Кофе)")
public class Task212 implements Solution {
    @Override
    public void execute() {
        // ===== Эспрессо =====
        Coffee coffee = new Espresso();
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");

        coffee = new Milk(coffee);
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");

        coffee = new Caramel(coffee);
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");

        coffee = new Chocolate(coffee);
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");

        // ===== Раф =====
        Coffee raf = new Raf();
        System.out.println("\n=== Раф ===");
        System.out.println(raf.getDescription() + " | Цена: $" + raf.getCost() + " | Калорийность: " + raf.getCalories() + " ккал");

        raf = new Milk(raf);
        System.out.println(raf.getDescription() + " | Цена: $" + raf.getCost() + " | Калорийность: " + raf.getCalories() + " ккал");

        raf = new Caramel(raf);
        System.out.println(raf.getDescription() + " | Цена: $" + raf.getCost() + " | Калорийность: " + raf.getCalories() + " ккал");
    }
}