package com.example;

public class Main {
    public static void main(String[] args) {

        int iterations = 3000;

        PerformanceComparison performanceComparison = new PerformanceComparison(iterations);

        performanceComparison.measurePerformance("add");
        performanceComparison.measurePerformance("delete");
        performanceComparison.measurePerformance("get");
    }
}

