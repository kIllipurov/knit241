package org.knit.solutions.lab2.task27;
import java.util.LinkedList;
import java.util.Queue;

public class Storage {
    private final int CAPACITY = 5;           // максимум товаров
    private final Queue<String> goods = new LinkedList<>();

    // Производитель кладет товар
    public synchronized void put(String item) throws InterruptedException {
        while (goods.size() == CAPACITY) {
            System.out.println("Склад полон! Maker ждёт...");
            wait();
        }
        goods.add(item);
        System.out.println("Maker создал: " + item + " | Товаров на складе: " + goods.size());
        notify(); // пробуждаем User
    }

    // Потребитель забирает товар
    public synchronized String take() throws InterruptedException {
        while (goods.isEmpty()) {
            System.out.println("Склад пуст! User ждёт...");
            wait();
        }
        String item = goods.poll();
        System.out.println("User забрал: " + item + " | Осталось на складе: " + goods.size());
        notify(); // пробуждаем Maker
        return item;
    }
}