package org.knit.solutions.lab2.task24;

public class GasStation {
    private int availablePumps = 2;

    public void refuel(String carName) {
        // Занять колонку
        synchronized (this) {
            try {
                while (availablePumps == 0) {
                    System.out.println(carName + " ждёт свободную колонку...");
                    wait();
                }
                availablePumps--;
                System.out.println(carName + " начал заправку. Свободные колонки: " + availablePumps);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }

        // Здесь потоки "работают" параллельно
        try {
            Thread.sleep(1000 + (int)(Math.random() * 2000)); // имитация заправки
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Освободить колонку
        synchronized (this) {
            availablePumps++;
            System.out.println(carName + " закончил заправку. Свободные колонки: " + availablePumps);
            notifyAll(); // уведомляем всех ожидающих
        }
    }
}
