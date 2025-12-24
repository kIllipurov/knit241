package org.knit.solutions.lab21.task212;

// ConcreteDecorator A
// Решил не писать все декораторы в одном файле, а вынести все отдельные классы в отдельные файлы
// Так вроде бы чище

public class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) { super(coffee); }

    @Override
    public double getCost() { return super.getCost() + 0.5; }

    @Override
    public String getDescription() { return super.getDescription() + ", молоко"; }

    @Override
    public int getCalories() { return super.getCalories() + 50; }
}
