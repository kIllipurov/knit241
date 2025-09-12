package org.knit.solutions.lab4.task411;

public class EmailNotifier implements StockObserver {
    private String email;

    public EmailNotifier(String email) {
        this.email = email;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("Email to " + email + ": Цена акции " + stockSymbol + " изменилась на " + price);
    }
}

