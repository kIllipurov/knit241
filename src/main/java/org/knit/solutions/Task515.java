package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab5.task515.*;

@TaskDescription(taskNumber = 515, taskDescription = "5.15 Подтягиваем фото с сервера + (Proxy)")
public class Task515 implements Solution {
    @Override
    public void execute() {
        Image image1 = new ImageProxy("photo1.jpg");
        Image image2 = new ImageProxy("photo2.jpg");

        // Первая загрузка photo1.jpg
        // image1.display();
        // System.out.println();

        // Вторая загрузка photo1.jpg — уже из кеша
        // image1.display();
        // System.out.println();

        long start = System.currentTimeMillis();
        image1.display(); // первый вызов → "загрузка"
        long duration = System.currentTimeMillis() - start;
        System.out.println("First display took: " + duration + " ms");

        start = System.currentTimeMillis();
        image1.display(); // повторный вызов → из кэша
        duration = System.currentTimeMillis() - start;
        System.out.println("Second display took: " + duration + " ms");

        // Загрузка photo2.jpg
        image2.display();
    }
}
