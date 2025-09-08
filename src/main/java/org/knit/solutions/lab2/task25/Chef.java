package org.knit.solutions.lab2.task25;

public class Chef extends Thread {
    private final Tray tray;
    private int dishNumber = 1;

    public Chef(Tray tray) {
        this.tray = tray;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String dish = "Блюдо-" + dishNumber++;
                tray.put(dish);

                // имитация долгого приготовления
                Thread.sleep(500 + (int)(Math.random() * 2000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
