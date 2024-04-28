package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class contains JUnit tests for comparing the performance of ArrayList
 * and LinkedList for various operations like add, delete and get.
 */
public class PerformanceComparisonTests {

    /**
     * The number of iterations to run the performance test.
     */
    private static final int ITERATIONS = 3000;

    /**
     * The number of times to run the performance test for each operation.
     */
    private static final int NUM_RUNS = 10;

    /**
     * Tests the performance of the 'add' operation for ArrayList and LinkedList.
     */
    @Test
    public void testAddPerformance() {
        PerformanceComparison performance = new PerformanceComparison(ITERATIONS);
        int arrayListWins = 0;
        int linkedListWins = 0;

        for (int i = 0; i < NUM_RUNS; i++) {
            long arrayListAddTime = performance.measureSinglePerformance("ArrayList", "add");
            long linkedListAddTime = performance.measureSinglePerformance("LinkedList", "add");

            if (arrayListAddTime < linkedListAddTime) {
                arrayListWins++;
            } else if (linkedListAddTime < arrayListAddTime) {
                linkedListWins++;
            }
        }
        if (arrayListWins > linkedListWins) {
            System.out.println("ArrayList addition performance in general is better than LinkedList addition performance, as expected.");
        }
        Assertions.assertTrue(arrayListWins > linkedListWins,
                "ArrayList add performance should be generally better than LinkedList add performance");
    }

    /**
     * Tests the performance of the 'delete' operation for ArrayList and LinkedList.
     */
    @Test
    public void testDeletePerformance() {
        PerformanceComparison performance = new PerformanceComparison(ITERATIONS);
        int arrayListWins = 0;
        int linkedListWins = 0;

        for (int i = 0; i < NUM_RUNS; i++) {
            long arrayListDeleteTime = performance.measureSinglePerformance("ArrayList", "delete");
            long linkedListDeleteTime = performance.measureSinglePerformance("LinkedList", "delete");

            if (arrayListDeleteTime < linkedListDeleteTime) {
                arrayListWins++;
            } else if (linkedListDeleteTime < arrayListDeleteTime) {
                linkedListWins++;
            }
        }
        if (arrayListWins < linkedListWins) {
            System.out.println("LinkedList deletion performance in general is better than ArrayList deletion performance, as expected.");
        }
        Assertions.assertTrue(linkedListWins > arrayListWins,
                "LinkedList delete performance should be generally better than ArrayList delete performance");
    }

    /**
     * Tests the performance of the 'get' operation for ArrayList and LinkedList.
     */
    @Test
    public void testGetPerformance() {
        PerformanceComparison performance = new PerformanceComparison(ITERATIONS);
        int arrayListWins = 0;
        int linkedListWins = 0;

        for (int i = 0; i < NUM_RUNS; i++) {
            long arrayListGetTime = performance.measureSinglePerformance("ArrayList", "get");
            long linkedListGetTime = performance.measureSinglePerformance("LinkedList", "get");

            if (arrayListGetTime < linkedListGetTime) {
                arrayListWins++;
            } else if (linkedListGetTime < arrayListGetTime) {
                linkedListWins++;
            }
        }

        if (arrayListWins > linkedListWins) {
            System.out.println("ArrayList get performance in general is better than LinkedList get performance, as expected.");
        }
        Assertions.assertTrue(arrayListWins > linkedListWins,
                "ArrayList get performance should be generally better than LinkedList get performance");
    }
}
