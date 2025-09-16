package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.task619.*;
import java.util.Arrays;

@TaskDescription(taskNumber = 619, taskDescription = "6.19 in-place Слияние двух массивов")
public class Task619 implements Solution {
    @Override
    public void execute() {
        MergeTwoArrays mergeTwoArrays = new MergeTwoArrays();

        // Пример 1
        int[] arr1_1 = {1, 2, 3, 0, 0, 0};
        int[] arr2_1 = {2, 5, 6};
        mergeTwoArrays.merge(arr1_1, 3, arr2_1, 3);
        System.out.println(Arrays.toString(arr1_1));

        // Пример 2
        int[] arr1_2 = {1};
        int[] arr2_2 = {};
        mergeTwoArrays.merge(arr1_2, 1, arr2_2, 0);
        System.out.println(Arrays.toString(arr1_2));

        // Пример 3
        int[] arr1_3 = {0};
        int[] arr2_3 = {1};
        mergeTwoArrays.merge(arr1_3, 0, arr2_3, 1);
        System.out.println(Arrays.toString(arr1_3));
    }
}