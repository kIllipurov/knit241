package task619;

import org.junit.Test;
import org.knit.solutions.task619.*;
import java.util.Arrays;
import static org.junit.Assert.*;
import java.util.Arrays;

public class Task619Test {

    @Test
    public void testMergeExamples() {
        MergeTwoArrays merge = new MergeTwoArrays();

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge.merge(nums1, 3, nums2, 3);
        assertArrayEquals(new int[]{1,2,2,3,5,6}, nums1);

        int[] nums3 = {1};
        int[] nums4 = {};
        merge.merge(nums3, 1, nums4, 0);
        assertArrayEquals(new int[]{1}, nums3);

        int[] nums5 = {0};
        int[] nums6 = {1};
        merge.merge(nums5, 0, nums6, 1);
        assertArrayEquals(new int[]{1}, nums5);
    }
}