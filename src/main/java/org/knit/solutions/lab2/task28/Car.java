package org.knit.solutions.lab2.task28;

public class Car extends Thread {
    private final TrafficLight light;
    private final String name;

    public Car(TrafficLight light, String name) {
        this.light = light;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) { // машина бесконечно катается
                light.pass(name);
                Thread.sleep(2000); // имитация езды до следующего перекрестка
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}