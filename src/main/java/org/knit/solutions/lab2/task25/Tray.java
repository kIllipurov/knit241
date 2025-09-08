package org.knit.solutions.lab2.task25;
import java.util.LinkedList;
import java.util.Queue;

public class Tray {
    private final int CAPACITY = 3;           // максимум 3 блюда
    private final Queue<String> dishes = new LinkedList<>();

    // повар кладет блюдо
    public synchronized void put(String dish) throws InterruptedException {
        while (dishes.size() == CAPACITY) {   // если поднос полный
            System.out.println("Поднос полон, повар ждёт...");
            wait();
        }

        dishes.add(dish);
        System.out.println("Повар приготовил: " + dish + " | Сейчас на подносе: " + dishes.size());
        notifyAll(); // будим официанта
    }

    // официант забирает блюдо
    public synchronized String take() throws InterruptedException {
        while (dishes.isEmpty()) {            // если поднос пуст
            System.out.println("Поднос пуст, официант ждёт...");
            wait();
        }

        String dish = dishes.poll();
        System.out.println("Официант подал: " + dish + " | Осталось на подносе: " + dishes.size());
        notifyAll(); // будим повара
        return dish;
    }
}
