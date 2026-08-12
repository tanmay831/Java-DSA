/**
 * ThreadCreationRunnable.java
 * 
 * Demonstrates creating threads by implementing the java.lang.Runnable interface.
 * 
 * Key Concepts:
 * 1. Preferred method over extending Thread because Java allows single class inheritance.
 * 2. Decouples task definition from thread execution logic.
 * 3. Can be written using anonymous classes or modern Lambda expressions.
 */

class CustomRunnableTask implements Runnable {
    @Override
    public void run() {
        System.out.println("[CustomRunnableTask] Executing in: " + Thread.currentThread().getName());
    }
}

public class ThreadCreationRunnable {
    public static void main(String[] args) {
        System.out.println("Main thread: " + Thread.currentThread().getName());

        // 1. Standard Runnable implementation
        CustomRunnableTask task1 = new CustomRunnableTask();
        Thread t1 = new Thread(task1, "Thread-Standard");
        t1.start();

        // 2. Runnable via Anonymous Inner Class
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("[Anonymous Class] Executing in: " + Thread.currentThread().getName());
            }
        }, "Thread-Anonymous");
        t2.start();

        // 3. Runnable via Lambda Expression (Java 8+)
        Runnable lambdaTask = () -> {
            System.out.println("[Lambda Expression] Executing in: " + Thread.currentThread().getName());
        };
        Thread t3 = new Thread(lambdaTask, "Thread-Lambda");
        t3.start();
    }
}
