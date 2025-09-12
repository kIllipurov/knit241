package org.knit.solutions.lab4.task411;
import java.util.ArrayList;
import java.util.List;

public class Stock {
    private String symbol;
    private double price;
    private List<StockObserver> observers = new ArrayList<>();

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public void subscribe(StockObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(StockObserver observer) {
        observers.remove(observer);
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public double getPrice() {
        return price;
    }

    private void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(symbol, price);
        }
    }
}