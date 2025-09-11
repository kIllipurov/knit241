package org.knit.solutions.lab2.task29;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// Класс-организатор
// хранит очереди для передачи деталей между этапами (штамповщик → сборщик → контроль → склад);
// инкапсуляция задачи
public class Conveyor {
    // Очереди между этапами
    private final BlockingQueue<Part> rawQueue = new ArrayBlockingQueue<>(10);   // штамповщик → сборщик
    private final BlockingQueue<Part> assembledQueue = new ArrayBlockingQueue<>(10); // сборщик → контроль
    private final BlockingQueue<Part> warehouse = new ArrayBlockingQueue<>(10); // склад
    private final BlockingQueue<Part> reworkQueue = new ArrayBlockingQueue<>(10); // очередь доработки брака

    public void startProduction() {
        new Stamper(rawQueue, reworkQueue).start();
        new Assembler(rawQueue, assembledQueue).start();
        new QualityOperator(assembledQueue, warehouse, reworkQueue).start();
    }
}