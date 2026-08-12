/**
 * ThreadLifecycleAndMethods.java
 * 
 * Demonstrates thread methods and states:
 * - sleep(): Pauses execution for a specified duration.
 * - join(): Waits for a thread to finish before proceeding.
 * - yield(): Gives a hint to thread scheduler to give CPU time to other threads.
 * - interrupt(): Signals a thread to stop or wake up from sleep/wait.
 * - getState(): Checks Thread.State (NEW, RUNNABLE, TIMED_WAITING, TERMINATED, etc.)
 */

public class ThreadLifecycleAndMethods {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            try {
                System.out.println("Worker thread state inside run(): " + Thread.currentThread().getState());
                System.out.println("Worker sleeping for 1.5 seconds...");
                Thread.sleep(1500);
                System.out.println("Worker woke up normally.");
            } catch (InterruptedException e) {
                System.out.println("Worker thread was INTERRUPTED while sleeping!");
            }
        }, "WorkerThread");

        System.out.println("1. State after instantiation: " + worker.getState());

        worker.start();
        System.out.println("2. State after start(): " + worker.getState());

        Thread.sleep(300);
        System.out.println("3. State while sleeping: " + worker.getState());

        System.out.println("4. Waiting for worker thread to complete using join()...");
        worker.join();

        System.out.println("5. State after completion: " + worker.getState());

        // Interruption demo
        System.out.println("\n--- Interruption Demo ---");
        Thread sleepyThread = new Thread(() -> {
            try {
                System.out.println("SleepyThread going to sleep for 5 seconds...");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("SleepyThread caught InterruptedException successfully!");
            }
        });
        sleepyThread.start();
        Thread.sleep(400);
        System.out.println("Main interrupting SleepyThread...");
        sleepyThread.interrupt();
        sleepyThread.join();

        System.out.println("Main program finished.");
    }
}
