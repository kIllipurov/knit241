package org.knit.solutions.lab21.task212;

// C ConcreteComponent A

public class Espresso implements Coffee {
    @Override
    public double getCost() { return 2.5; }

    @Override
    public String getDescription() { return "Эспрессо"; }

    @Override
    public int getCalories() { return 5; }
}