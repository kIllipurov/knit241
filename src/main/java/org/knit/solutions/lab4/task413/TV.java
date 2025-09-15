package org.knit.solutions.lab4.task413;

public class TV {
    private final String location;

    public TV(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " TV is ON");
    }

    public void off() {
        System.out.println(location + " TV is OFF");
    }
}
