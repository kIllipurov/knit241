package org.knit.solutions.lab21.task212;

// ConcreteDecorator B

public class Caramel extends CoffeeDecorator {
    public Caramel(Coffee coffee) { super(coffee); }

    @Override
    public double getCost() { return super.getCost() + 0.75; }

    @Override
    public String getDescription() { return super.getDescription() + ", карамель"; }

    @Override
    public int getCalories() { return super.getCalories() + 60; }
}
