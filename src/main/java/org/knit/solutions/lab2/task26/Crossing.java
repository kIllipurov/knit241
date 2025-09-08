package org.knit.solutions.lab2.task26;

public class Crossing {
    private boolean trainComing = false;

    public synchronized void carArrive(String name) throws InterruptedException {
        while (trainComing) {  // если поезд едет
            System.out.println(name + " ждет поезд...");
            wait();
        }
        System.out.println(name + " проехала переезд!");
    }

    public synchronized void trainArrive() throws InterruptedException {
        trainComing = true;
        System.out.println("Поезд подъехал! Машины останавливаются...");
        Thread.sleep(2000); // имитация движения поезда
        trainComing = false;
        System.out.println("Поезд проехал! Машины могут ехать.");
        notifyAll(); // будим все ожидающие машины
    }
}
