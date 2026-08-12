/**
 * AtomicVariablesDemo.java
 * 
 * Demonstrates lock-free thread safety using Atomic classes (AtomicInteger, AtomicBoolean, etc.).
 * 
 * Key Concepts:
 * 1. Standard count++ is NOT atomic.
 * 2. java.util.concurrent.atomic classes use low-level CPU instructions like Compare-And-Swap (CAS).
 * 3. Provides thread-safety without heavy synchronization locking overhead.
 */

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariablesDemo {
    private static int unsafeCount = 0;
    private static final AtomicInteger atomicCount = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                unsafeCount++;
                atomicCount.incrementAndGet();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                unsafeCount++;
                atomicCount.incrementAndGet();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Expected Count: 20000");
        System.out.println("Unsafe Int Count (May suffer race condition): " + unsafeCount);
        System.out.println("AtomicInteger Count (Guaranteed thread-safe): " + atomicCount.get());
    }
}
