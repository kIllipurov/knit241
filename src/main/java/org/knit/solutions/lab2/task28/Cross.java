package org.knit.solutions.lab2.task28;

public class Cross {
    private final TrafficLight trafficLight = new TrafficLight();

    public void startSimulation() {
        // создаём несколько машин
        for (int i = 1; i <= 5; i++) {
            new Car(trafficLight, "Машина " + i).start();
        }

        // запускаем светофор
        new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(5000); // каждые 5 секунд переключение
                    synchronized (trafficLight) {
                        trafficLight.switchLight();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
