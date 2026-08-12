/**
 * DeadlockDemoAndPrevention.java
 * 
 * Demonstrates Deadlock concepts and prevention via Lock Ordering.
 * 
 * Key Concepts:
 * 1. Deadlock occurs when 2 or more threads are blocked forever, each waiting for a lock held by the other.
 * 2. Prevention Strategy: Enforce consistent Lock Ordering (always acquire locks in the exact same global order across all threads).
 */

class LockableResource {
    private final String name;

    public LockableResource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class DeadlockDemoAndPrevention {
    private static final LockableResource lockA = new LockableResource("Resource-A");
    private static final LockableResource lockB = new LockableResource("Resource-B");

    public static void safeTransfer(LockableResource res1, LockableResource res2) {
        LockableResource firstLock = res1.getName().compareTo(res2.getName()) < 0 ? res1 : res2;
        LockableResource secondLock = res1.getName().compareTo(res2.getName()) < 0 ? res2 : res1;

        synchronized (firstLock) {
            System.out.println(Thread.currentThread().getName() + " acquired " + firstLock.getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (secondLock) {
                System.out.println(Thread.currentThread().getName() + " acquired " + secondLock.getName());
                System.out.println("--> Task executed safely without deadlock!");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Executing threads with consistent lock ordering to prevent deadlock...");

        Thread t1 = new Thread(() -> safeTransfer(lockA, lockB), "Thread-1");
        Thread t2 = new Thread(() -> safeTransfer(lockB, lockA), "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("All threads finished safely!");
    }
}
