/**
 * CallableAndFuture.java
 * 
 * Demonstrates Callable<V> and Future<V> for returning results from concurrent tasks.
 * 
 * Key Concepts:
 * 1. Callable<V> defines a call() method returning result of type V.
 * 2. Future<V> acts as a handle to access result once computation completes.
 * 3. future.get() blocks until result is ready!
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class FactorialCalculator implements Callable<Long> {
    private final int number;

    public FactorialCalculator(int number) {
        this.number = number;
    }

    @Override
    public Long call() throws Exception {
        System.out.println("Calculating factorial of " + number + " on thread: " + Thread.currentThread().getName());
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
            Thread.sleep(80);
        }
        return result;
    }
}

public class CallableAndFuture {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        System.out.println("Submitting FactorialCalculator for 10...");
        Future<Long> future = executor.submit(new FactorialCalculator(10));

        System.out.println("Main thread is free to do other work while calculation is happening...");

        while (!future.isDone()) {
            System.out.println("Calculation still in progress... waiting...");
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Long factorialResult = future.get();
            System.out.println("\nSUCCESS: Factorial of 10 = " + factorialResult);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Task execution failed: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
}
