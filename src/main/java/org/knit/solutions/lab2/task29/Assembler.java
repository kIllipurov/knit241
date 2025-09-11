package org.knit.solutions.lab2.task29;
import java.util.concurrent.BlockingQueue;
// Сборщик
// Берет заготовку из очереди
// Собирает её
// Кладет обратно в очередь
public class Assembler extends Thread {
    private final BlockingQueue<Part> rawQueue;
    private final BlockingQueue<Part> assembledQueue;

    public Assembler(BlockingQueue<Part> rawQueue, BlockingQueue<Part> assembledQueue) {
        this.rawQueue = rawQueue;
        this.assembledQueue = assembledQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Part part = rawQueue.take(); // ждем заготовку
                part.setAssembled(true);
                System.out.println("Сборщик: " + part + " обработана");
                assembledQueue.put(part); // передаем дальше
                Thread.sleep(1000 + (int)(Math.random() * 500));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}