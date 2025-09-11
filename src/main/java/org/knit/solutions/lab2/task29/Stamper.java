package org.knit.solutions.lab2.task29;
import java.util.concurrent.BlockingQueue;
// Штамповщик
// Создает деталь -> кладет в очередь
public class Stamper extends Thread {
    private final BlockingQueue<Part> rawQueue;
    private final BlockingQueue<Part> reworkQueue;
    private int counter = 1;

    public Stamper(BlockingQueue<Part> rawQueue, BlockingQueue<Part> reworkQueue) {
        this.rawQueue = rawQueue;
        this.reworkQueue = reworkQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Part part;

                // сначала проверяем очередь брака
                part = reworkQueue.poll();
                if (part != null) {
                    System.out.println("Штамповщик: перерабатывает " + part + " из брака");
                } else {
                    part = new Part(counter++);
                    System.out.println("Штамповщик: " + part + " создана");
                }

                rawQueue.put(part);
                System.out.println("rawQueue размер: " + rawQueue.size());
                Thread.sleep(1500 + (int) (Math.random() * 500));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
