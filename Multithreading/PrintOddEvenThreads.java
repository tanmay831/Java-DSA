/**
 * PrintOddEvenThreads.java
 * 
 * Classic Multithreading Interview Problem:
 * Print numbers sequentially from 1 to N using two threads (one printing Odd, one printing Even).
 */

class SequentialOddEvenPrinter {
    private int counter = 1;
    private final int limit;

    public SequentialOddEvenPrinter(int limit) {
        this.limit = limit;
    }

    public synchronized void printOdd() {
        while (counter <= limit) {
            while (counter % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            if (counter <= limit) {
                System.out.println(Thread.currentThread().getName() + ": " + counter);
                counter++;
                notify();
            }
        }
    }

    public synchronized void printEven() {
        while (counter <= limit) {
            while (counter % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            if (counter <= limit) {
                System.out.println(Thread.currentThread().getName() + ": " + counter);
                counter++;
                notify();
            }
        }
    }
}

public class PrintOddEvenThreads {
    public static void main(String[] args) {
        int maxLimit = 10;
        SequentialOddEvenPrinter printer = new SequentialOddEvenPrinter(maxLimit);

        Thread oddThread = new Thread(printer::printOdd, "Odd-Thread");
        Thread evenThread = new Thread(printer::printEven, "Even-Thread");

        oddThread.start();
        evenThread.start();
    }
}
