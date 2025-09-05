package org.knit.solutions.lab21.task212;

// ConcreteDecorator C

public class Chocolate extends CoffeeDecorator {
    public Chocolate(Coffee coffee) { super(coffee); }

    @Override
    public double getCost() { return super.getCost() + 1.0; }

    @Override
    public String getDescription() { return super.getDescription() + ", шоколад"; }

    @Override
    public int getCalories() { return super.getCalories() + 80; }
}