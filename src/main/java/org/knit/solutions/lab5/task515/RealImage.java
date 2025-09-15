package org.knit.solutions.lab5.task515;

public class RealImage implements Image {
    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromServer();
    }

    private void loadFromServer() {
        try {
            System.out.println("Loading " + filename + " from server...");
            Thread.sleep(1000); // имитация задержки загрузки
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(filename + " loaded.");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}