/**
 * ExecutorServiceDemo.java
 * 
 * Demonstrates the Java Executor Framework (Thread Pools).
 * 
 * Key Concepts:
 * 1. Thread pools reuse existing threads instead of creating new threads for every task.
 * 2. Executors.newFixedThreadPool(n): Fixed pool size.
 * 3. executor.shutdown() initiates orderly shutdown; executor.shutdownNow() interrupts active tasks.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class PoolTask implements Runnable {
    private final int taskId;

    public PoolTask(int id) {
        this.taskId = id;
    }

    @Override
    public void run() {
        System.out.println("--> Task #" + taskId + " executing on thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            System.out.println("Task #" + taskId + " interrupted.");
        }
        System.out.println("<-- Task #" + taskId + " completed.");
    }
}

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        System.out.println("Creating Fixed Thread Pool with 3 threads...");
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 6; i++) {
            executor.execute(new PoolTask(i));
        }

        executor.shutdown();
        System.out.println("Executor shutdown initiated.");

        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("All tasks executed and thread pool closed successfully.");
    }
}
