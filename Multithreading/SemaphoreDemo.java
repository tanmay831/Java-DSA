/**
 * SemaphoreDemo.java
 * 
 * Demonstrates java.util.concurrent.Semaphore.
 * 
 * Key Concepts:
 * 1. Semaphore maintains permits to restrict access to a finite resource pool.
 * 2. acquire(): Obtains a permit, blocking if none available.
 * 3. release(): Returns a permit to the semaphore.
 */

import java.util.concurrent.Semaphore;

class DatabaseConnectionPool {
    private final Semaphore semaphore;

    public DatabaseConnectionPool(int maxPermits) {
        this.semaphore = new Semaphore(maxPermits);
    }

    public void accessDatabase(String threadName) {
        try {
            System.out.println(threadName + " requesting DB connection...");
            semaphore.acquire();

            System.out.println("--> " + threadName + " ACQUIRED DB connection! Available permits: " + semaphore.availablePermits());
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("<-- " + threadName + " RELEASING DB connection.");
            semaphore.release();
        }
    }
}

public class SemaphoreDemo {
    public static void main(String[] args) {
        DatabaseConnectionPool pool = new DatabaseConnectionPool(2);

        for (int i = 1; i <= 4; i++) {
            final String name = "UserThread-" + i;
            new Thread(() -> pool.accessDatabase(name)).start();
        }
    }
}
