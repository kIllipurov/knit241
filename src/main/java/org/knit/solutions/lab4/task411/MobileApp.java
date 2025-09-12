package org.knit.solutions.lab4.task411;

public class MobileApp implements StockObserver {
    private String user;

    public MobileApp(String user) {
        this.user = user;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("MobileApp - " + user + ": Цена акции " + stockSymbol + " изменилась на " + price);
    }
}