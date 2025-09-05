package org.knit.solutions.lab21.task212;

// C Concretecomponent. Ещё одна сущность, как Espresso

public class Raf implements Coffee {
    @Override
    public double getCost() { return 3.0; }

    @Override
    public String getDescription() { return "Раф"; }

    @Override
    public int getCalories() { return 10; }
}