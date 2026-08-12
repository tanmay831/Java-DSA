/**
 * VolatileKeywordDemo.java
 * 
 * Demonstrates the 'volatile' keyword in Java Multithreading.
 * 
 * Key Concepts:
 * 1. Threads often cache shared variables in CPU L1/L2 caches for performance.
 * 2. 'volatile' ensures reads/writes go directly to Main Memory (RAM), guaranteeing visibility across threads.
 */

public class VolatileKeywordDemo {
    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            System.out.println("Worker thread waiting for flag to become true...");
            while (!flag) {
                // Busy wait until main thread sets flag = true
            }
            System.out.println("Worker thread detected flag = true! Resuming work.");
        });

        worker.start();

        Thread.sleep(800);

        System.out.println("Main thread changing flag to true...");
        flag = true;

        worker.join();
        System.out.println("Program completed successfully.");
    }
}
