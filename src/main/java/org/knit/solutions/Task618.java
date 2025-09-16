package org.knit.solutions;
import org.knit.TaskDescription;
import org.knit.solutions.task618.*;
import java.util.Arrays;
import java.util.Scanner;

@TaskDescription(taskNumber = 618, taskDescription = "6.18 in-place модификация массива")
public class Task618 implements Solution {
    @Override
    public void execute() {
        int[] arr = {1,0,2,3,0,4,5,0};
        System.out.println("Вход:  " + Arrays.toString(arr));

        DuplicateZeros.duplicateZeros(arr);

        System.out.println("Выход: " + Arrays.toString(arr));
    }
}
