package org.knit.solutions.lab2.task26;

public class Car extends Thread {
    private final Crossing crossing;
    private final String name;

    public Car(Crossing crossing, String name) {
        this.crossing = crossing;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
            crossing.carArrive(name);
            Thread.sleep(500 + (int)(Math.random() * 1000)); // имитация движения
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

