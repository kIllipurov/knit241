package org.knit.solutions.lab2.task29;
import java.util.concurrent.BlockingQueue;

// Контроль качества
// Берет деталь собранную
// проверяет (брак?)
// Если брак -> обратно
// Если норм -> склад
public class QualityOperator extends Thread {
    private final BlockingQueue<Part> assembledQueue;
    private final BlockingQueue<Part> warehouse;
    private final BlockingQueue<Part> reworkQueue;

    public QualityOperator(BlockingQueue<Part> assembledQueue, BlockingQueue<Part> warehouse,
                           BlockingQueue<Part> reworkQueue) {
        this.assembledQueue = assembledQueue;
        this.warehouse = warehouse;
        this.reworkQueue = reworkQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Part part = assembledQueue.take();

                if (Math.random() < 0.3) { // 30% брака
                    System.out.println("Оператор контроля: " + part + " БРАК! Отправка на доработку");
                    reworkQueue.put(part);
                } else {
                    part.setChecked(true);
                    warehouse.put(part);
                    System.out.println("Оператор контроля: " + part + " проверена и отправлена на склад | warehouse: " + warehouse.size());
                }

                Thread.sleep(500 + (int)(Math.random() * 500)); // быстрый оператор
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}