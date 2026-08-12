/**
 * WaitNotifyProducerConsumer.java
 * 
 * Demonstrates Inter-Thread Communication using wait(), notify(), and notifyAll().
 * 
 * Key Concepts:
 * 1. wait(): Releases the object lock and pauses thread execution until notified.
 * 2. notifyAll(): Wakes up all threads waiting on the object monitor.
 * 3. wait()/notify() MUST be called inside a synchronized block on the shared object.
 */

import java.util.LinkedList;
import java.util.Queue;

class WaitNotifyBuffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int CAPACITY = 3;

    public synchronized void produce(int item) throws InterruptedException {
        while (queue.size() == CAPACITY) {
            System.out.println("[Producer] Buffer is FULL. Waiting...");
            wait();
        }

        queue.add(item);
        System.out.println("[Producer] Produced item: " + item + " (Buffer size: " + queue.size() + ")");
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("[Consumer] Buffer is EMPTY. Waiting...");
            wait();
        }

        int item = queue.poll();
        System.out.println("[Consumer] Consumed item: " + item + " (Buffer size: " + queue.size() + ")");
        notifyAll();

        return item;
    }
}

public class WaitNotifyProducerConsumer {
    public static void main(String[] args) {
        WaitNotifyBuffer buffer = new WaitNotifyBuffer();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.produce(i * 10);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Producer");

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.consume();
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Consumer");

        producer.start();
        consumer.start();
    }
}
