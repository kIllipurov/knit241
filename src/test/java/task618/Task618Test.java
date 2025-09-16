package task618;

import org.junit.Test;
import org.knit.solutions.task618.DuplicateZeros;

import static org.junit.Assert.*;
        import java.util.Arrays;

public class Task618Test {

    @Test
    public void testExample1() {
        int[] arr = {1,0,2,3,0,4,5,0};
        int[] expected = {1,0,0,2,3,0,0,4};
        DuplicateZeros.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testExample2() {
        int[] arr = {1,2,3};
        int[] expected = {1,2,3};
        DuplicateZeros.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testAllZeros() {
        int[] arr = {0,0,0,0};
        int[] expected = {0,0,0,0};
        DuplicateZeros.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testZerosAtEdges() {
        int[] arr = {0,1,2,3,0};
        int[] expected = {0,0,1,2,3};
        DuplicateZeros.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testNoZeros() {
        int[] arr = {5,6,7,8};
        int[] expected = {5,6,7,8};
        DuplicateZeros.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testLargeArrayPerformance() {
        int n = 10000;
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        arr[5000] = 0;

        long start = System.currentTimeMillis();
        DuplicateZeros.duplicateZeros(arr);
        long end = System.currentTimeMillis();

        System.out.println("Performance test took: " + (end - start) + " ms");
        assertTrue("Performance test took too long", (end - start) < 200);
    }
}
