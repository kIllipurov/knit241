package org.knit.solutions.lab5.task515;

public class ImageProxy implements Image {
    private final String filename;
    private RealImage realImage;

    public ImageProxy(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) { // ленивое создание
            realImage = new RealImage(filename);
        }
        realImage.display(); // повторное использование кэшированного объекта
    }
}