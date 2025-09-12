package org.knit.solutions.lab3.task310;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Race {
    private final int runnerCount;

    public Race(int runnerCount) {
        this.runnerCount = runnerCount;
    }

    public void startRace() {
        // Действие после того как все дождались barrier.await()
        CyclicBarrier startBarrier = new CyclicBarrier(runnerCount,
                () -> System.out.println("\n🚩 Все участники на старте! Гонка началась!\n")
        );

        ExecutorService executor = Executors.newFixedThreadPool(runnerCount);

        for (int i = 1; i <= runnerCount; i++) {
            executor.execute(new Runner("Бегун " + i, startBarrier));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // ждём завершения всех потоков
        }
        System.out.println("\n🏁 Гонка завершена!");
    }
}
