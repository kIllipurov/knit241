package org.knit.solutions.lab2.task26;

public class Train extends Thread {
    private final Crossing crossing;

    public Train(Crossing crossing) {
        this.crossing = crossing;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000); // имитация приближения
                crossing.trainArrive();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}