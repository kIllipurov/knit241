package org.knit.solutions.lab2.task27;

public class Maker extends Thread {
    private final Storage storage;
    private int counter = 1;

    public Maker(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String item = "Товар-" + counter++;
                storage.put(item);
                Thread.sleep(500); // имитация производства
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}