package com.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This class is used to compare the performance of ArrayList and LinkedList
 * for various operations like add, delete and get.
 */
public class PerformanceComparison {

    /**
     * The number of iterations to run the performance test.
     */
    private int iterations;

    /**
     * Constructs a new PerformanceComparison object with the specified number of iterations.
     *
     * @param iterations the number of iterations to run the performance test
     */
    public PerformanceComparison(int iterations) {
        this.iterations = iterations;
    }

    /**
     * Measures the performance of the specified method ('add', 'delete', or 'get')
     * for both ArrayList and LinkedList.
     *
     * @param method the method to measure the performance of
     */
    public void measurePerformance(String method) {
        long startTime, endTime;
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        switch (method.toLowerCase()) {
            case "add":
                startTime = System.nanoTime();
                for (int i = 0; i < iterations; i++) {
                    arrayList.add(i);
                }
                endTime = System.nanoTime();
                System.out.println("ArrayList add: " + (endTime - startTime)/iterations + " ns");

                startTime = System.nanoTime();
                for (int i = 0; i < iterations; i++) {
                    linkedList.add(i);
                }
                endTime = System.nanoTime();
                System.out.println("LinkedList add: " + (endTime - startTime)/iterations + " ns");
                break;

            case "delete":
                for (int i = 0; i < iterations; i++) {
                    arrayList.add(i);
                    linkedList.add(i);
                }

                startTime = System.nanoTime();
                for (int i = 0; i < iterations; i++) {
                    arrayList.remove(0);
                }
                endTime = System.nanoTime();
                System.out.println("ArrayList delete: " + (endTime - startTime)/iterations + " ns");

                startTime = System.nanoTime();
                for (int i = 0; i < iterations; i++) {
                    linkedList.remove(0);
                }
                endTime = System.nanoTime();
                System.out.println("LinkedList delete: " + (endTime - startTime)/iterations + " ns");
                break;

            case "get":
                for (int i = 0; i < iterations; i++) {
                    arrayList.add(i);
                    linkedList.add(i);
                }

                startTime = System.nanoTime();
                for (int i = 0; i < iterations; i++) {
                    arrayList.get(i);
                }
                endTime = System.nanoTime();
                System.out.println("ArrayList get: " + (endTime - startTime)/iterations + " ns");

                startTime = System.nanoTime();
                for (int i = 0; i < iterations; i++) {
                    linkedList.get(i);
                }
                endTime = System.nanoTime();
                System.out.println("LinkedList get: " + (endTime - startTime)/iterations + " ns");
                break;

            default:
                System.out.println("Invalid method");
        }
    }

    /**
     * Measures the performance of the specified method ('add', 'delete', or 'get')
     * for the specified data structure ('ArrayList' or 'LinkedList').
     *
     * @param dataStructure the data structure to measure the performance of
     * @param method the method to measure the performance of
     * @return the time taken to perform the operation in nanoseconds
     * @throws IllegalArgumentException if the specified data structure or method is invalid
     */
    public long measureSinglePerformance(String dataStructure, String method) {
        long startTime, endTime;
        List<Integer> list;
        if (dataStructure.equalsIgnoreCase("ArrayList")) {
            list = new ArrayList<>();
        } else if (dataStructure.equalsIgnoreCase("LinkedList")) {
            list = new LinkedList<>();
        } else {
            throw new IllegalArgumentException("Invalid data structure: " + dataStructure);
        }

        switch (method.toLowerCase()) {
            case "add":
                startTime = System.nanoTime();
                for (int i = 0; i < iterations; i++) {
                    list.add(i);
                }
                endTime = System.nanoTime();
                break;

            case "delete":
                for (int i = 0; i < iterations; i++) {
                    list.add(i);
                }

                startTime = System.nanoTime();
                for (int i = 0; i < iterations; i++) {
                    list.remove(0);
                }
                endTime = System.nanoTime();
                break;

            case "get":
                for (int i = 0; i < iterations; i++) {
                    list.add(i);
                }

                startTime = System.nanoTime();
                for (int i = 0; i < iterations; i++) {
                    list.get(i);
                }
                endTime = System.nanoTime();
                break;

            default:
                throw new IllegalArgumentException("Invalid method: " + method);
        }

        return endTime - startTime;
    }
}