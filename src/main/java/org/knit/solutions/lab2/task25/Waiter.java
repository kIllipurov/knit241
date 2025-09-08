package org.knit.solutions.lab2.task25;

public class Waiter extends Thread {
    private final Tray tray;

    public Waiter(Tray tray) {
        this.tray = tray;
    }

    @Override
    public void run() {
        try {
            while (true) {
                tray.take();

                // имитация долгой подачи
                Thread.sleep(500 + (int)(Math.random() * 2000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
