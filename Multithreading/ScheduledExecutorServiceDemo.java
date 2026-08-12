/**
 * ScheduledExecutorServiceDemo.java
 * 
 * Demonstrates scheduling delayed and periodic tasks using ScheduledExecutorService.
 * 
 * Key Concepts:
 * 1. schedule(): Runs task after an initial delay.
 * 2. scheduleAtFixedRate(): Runs task periodically relative to start time.
 */

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        scheduler.schedule(() -> {
            System.out.println("[One-Time Task] Executed after 1s delay!");
        }, 1, TimeUnit.SECONDS);

        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("[Periodic Task] Heartbeat tick at: " + System.currentTimeMillis() % 10000);
        }, 500, 500, TimeUnit.MILLISECONDS);

        Thread.sleep(2500);

        System.out.println("Shutting down scheduler...");
        scheduler.shutdown();
    }
}
