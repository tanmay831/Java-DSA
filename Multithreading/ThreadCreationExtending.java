/**
 * ThreadCreationExtending.java
 * 
 * Demonstrates thread creation by extending the java.lang.Thread class.
 * 
 * Key Concepts:
 * 1. Override the run() method to define the task to be executed concurrently.
 * 2. Call start() to create a new call stack and initiate thread execution.
 * 3. Calling run() directly executes on the current thread, NOT concurrently!
 */

class SimpleWorkerThread extends Thread {
    private final String threadName;

    public SimpleWorkerThread(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        System.out.println("--> " + threadName + " has STARTED running on thread: " + Thread.currentThread().getName());
        for (int i = 1; i <= 5; i++) {
            System.out.println("[" + threadName + "] Count: " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("[" + threadName + "] Interrupted!");
            }
        }
        System.out.println("<-- " + threadName + " has FINISHED execution.");
    }
}

public class ThreadCreationExtending {
    public static void main(String[] args) {
        System.out.println("Main thread started: " + Thread.currentThread().getName());

        SimpleWorkerThread t1 = new SimpleWorkerThread("Worker-1");
        SimpleWorkerThread t2 = new SimpleWorkerThread("Worker-2");

        t1.start();
        t2.start();

        System.out.println("Main thread continues executing while worker threads run...");
    }
}
