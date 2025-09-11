package org.knit.solutions.lab2.task28;

public class TrafficLight {
    private boolean green = false; // начнем с красного

    // Машина проверяет светофор
    public synchronized void pass(String name) throws InterruptedException {
        while (!green) { // если красный
            System.out.println(name + " стоит на красный...");
            wait();
        }
        System.out.println(name + " проехала перекресток!");
    }

    // Переключение сигнала светофора
    public synchronized void switchLight() {
        green = !green;
        if (green) {
            System.out.println("Светофор: ЗЕЛЕНЫЙ! Машины могут ехать.");
            notifyAll(); // будим всех ждущих машин
        } else {
            System.out.println("Светофор: КРАСНЫЙ! Машины должны остановиться.");
        }
    }
}