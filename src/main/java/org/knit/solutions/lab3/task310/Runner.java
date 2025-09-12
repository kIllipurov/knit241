package org.knit.solutions.lab3.task310;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class Runner implements Runnable {
    private final String name;
    private final CyclicBarrier barrier;

    public Runner(String name, CyclicBarrier barrier) {
        this.name = name;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " готовится к старту...");
            Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000)); // подготовка

            System.out.println(name + " встал на стартовую линию и ждёт остальных.");
            barrier.await(); // ждём всех участников

            System.out.println(name + " стартовал!");
            Thread.sleep(ThreadLocalRandom.current().nextInt(500, 3000)); // "бежит"

            if (ThreadLocalRandom.current().nextInt(100) < 20) { // 20 процетный шанс сойти с дистанции. Доп задание
                System.out.println("name " + " получил травму и сошёл с дистанции!");
                return; // поток завершится, бегун не финиширует
            }

            Thread.sleep(ThreadLocalRandom.current().nextInt(500, 3000)); // "бежит"
            System.out.println(name + " финишировал!");

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
