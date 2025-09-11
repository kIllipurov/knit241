package org.knit.solutions.lab2.task27;

public class User extends Thread {
    private final Storage storage;

    public User(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            while (true) {
                storage.take();
                Thread.sleep(1000); // имитация использования товара
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}