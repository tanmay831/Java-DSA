/**
 * SynchronizedBlock.java
 * 
 * Demonstrates Synchronized Blocks for fine-grained locking.
 * 
 * Key Concepts:
 * 1. Synchronized methods lock the ENTIRE method and object instance.
 * 2. Synchronized blocks only lock the critical section of code, improving performance.
 */

class FineGrainedCounter {
    private int count = 0;
    private final Object lock = new Object();

    public void increment() {
        // Non-critical code executed concurrently
        String threadName = Thread.currentThread().getName();

        // Synchronized Block
        synchronized (lock) {
            count++;
        }
    }

    public int getCount() {
        synchronized (lock) {
            return count;
        }
    }
}

public class SynchronizedBlock {
    public static void main(String[] args) throws InterruptedException {
        FineGrainedCounter counter = new FineGrainedCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 500; i++) counter.increment();
        }, "Thread-A");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 500; i++) counter.increment();
        }, "Thread-B");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Expected Count: 1000");
        System.out.println("Actual Count: " + counter.getCount());
    }
}
