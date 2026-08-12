/**
 * CountDownLatchDemo.java
 * 
 * Demonstrates java.util.concurrent.CountDownLatch.
 * 
 * Key Concepts:
 * 1. CountDownLatch allows one or more threads to wait until a set of operations completes.
 * 2. latch.countDown() decrements count.
 * 3. latch.await() blocks until count reaches 0.
 */

import java.util.concurrent.CountDownLatch;

class AppServiceInitializer implements Runnable {
    private final String serviceName;
    private final CountDownLatch latch;

    public AppServiceInitializer(String serviceName, CountDownLatch latch) {
        this.serviceName = serviceName;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Initializing " + serviceName + "...");
            Thread.sleep((int) (Math.random() * 800) + 300);
            System.out.println("[SUCCESS] " + serviceName + " initialized.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
    }
}

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        int numberOfServices = 3;
        CountDownLatch latch = new CountDownLatch(numberOfServices);

        System.out.println("Starting application services initialization...");

        new Thread(new AppServiceInitializer("Database Service", latch)).start();
        new Thread(new AppServiceInitializer("Cache Service", latch)).start();
        new Thread(new AppServiceInitializer("Messaging Service", latch)).start();

        System.out.println("Main thread waiting for all " + numberOfServices + " services to initialize...");
        latch.await();

        System.out.println("\nAll services initialized! Server is READY to accept traffic.");
    }
}
