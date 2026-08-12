/**
 * ReentrantLockDemo.java
 * 
 * Demonstrates explicit locking using java.util.concurrent.locks.ReentrantLock.
 * 
 * Key Concepts:
 * 1. ReentrantLock offers features like tryLock(), lockInterruptibly(), and fair locking.
 * 2. ALWAYS release the lock inside a `finally` block to prevent deadlocks!
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private static final ReentrantLock lock = new ReentrantLock(true);

    public static void performTask(String workerName) {
        System.out.println(workerName + " attempting to acquire lock...");

        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    System.out.println("--> " + workerName + " ACQUIRED lock. Executing critical section...");
                    Thread.sleep(1500);
                } finally {
                    System.out.println("<-- " + workerName + " RELEASING lock.");
                    lock.unlock();
                }
            } else {
                System.out.println("x " + workerName + " COULD NOT acquire lock (timed out). Doing fallback work.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> performTask("Worker-A"));
        Thread t2 = new Thread(() -> performTask("Worker-B"));

        t1.start();
        t2.start();
    }
}
