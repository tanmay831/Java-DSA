/**
 * StaticSynchronization.java
 * 
 * Demonstrates Class-Level Locking via Static Synchronized Methods.
 * 
 * Key Concepts:
 * 1. Object lock (`synchronized` method) locks a specific INSTANCE (`this`).
 * 2. Static synchronized method locks the entire CLASS (`ClassName.class`).
 */

class MultiplicationTableDisplay {
    public static synchronized void printTable(int n) {
        System.out.println("\n--- Table for " + n + " (Thread: " + Thread.currentThread().getName() + ") ---");
        for (int i = 1; i <= 5; i++) {
            System.out.println(n + " * " + i + " = " + (n * i));
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class StaticSynchronization {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> MultiplicationTableDisplay.printTable(5), "Thread-1");
        Thread t2 = new Thread(() -> MultiplicationTableDisplay.printTable(10), "Thread-2");
        Thread t3 = new Thread(() -> MultiplicationTableDisplay.printTable(100), "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
