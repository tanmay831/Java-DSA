/**
 * DaemonThreads.java
 * 
 * Demonstrates Daemon Threads in Java.
 * 
 * Key Concepts:
 * 1. Daemon threads are background threads (e.g., Garbage Collector).
 * 2. JVM exits immediately when all User (Non-Daemon) threads complete execution,
 *    even if Daemon threads are still running!
 * 3. setDaemon(true) MUST be called before starting the thread.
 */

public class DaemonThreads {
    public static void main(String[] args) throws InterruptedException {
        Thread daemonThread = new Thread(() -> {
            int count = 0;
            while (true) {
                count++;
                System.out.println("[Daemon Thread] Heartbeat check #" + count);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println("[Daemon Thread] Interrupted.");
                    break;
                }
            }
        }, "Background-Daemon");

        daemonThread.setDaemon(true);
        daemonThread.start();

        System.out.println("[User Thread Main] Doing work for 1 second...");
        Thread.sleep(1000);
        System.out.println("[User Thread Main] Main work finished. Exiting...");
    }
}
