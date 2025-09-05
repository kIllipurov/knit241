package org.knit.solutions.lab2;

public class Car extends Thread {
    private final GasStation station;

    public Car(String name, GasStation station) {
        super(name); // имя передаём в родительский Thread
        this.station = station;
    }

    @Override
    public void run() {
        station.refuel(getName()); // берём имя потока
    }
}