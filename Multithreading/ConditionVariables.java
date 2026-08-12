/**
 * ConditionVariables.java
 * 
 * Demonstrates explicit Condition variables using java.util.concurrent.locks.Condition.
 * 
 * Key Concepts:
 * 1. ReentrantLock paired with Condition provides flexible thread signaling.
 * 2. condition.await() replaces Object.wait()
 * 3. condition.signal() replaces Object.notify()
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ConditionBuffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity = 2;
    private final Lock lock = new ReentrantLock();

    private final Condition isNotFull = lock.newCondition();
    private final Condition isNotEmpty = lock.newCondition();

    public void produce(int item) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                System.out.println("[Producer] Buffer full. Awaiting isNotFull condition...");
                isNotFull.await();
            }

            queue.add(item);
            System.out.println("[Producer] Produced: " + item);
            isNotEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int consume() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                System.out.println("[Consumer] Buffer empty. Awaiting isNotEmpty condition...");
                isNotEmpty.await();
            }

            int item = queue.poll();
            System.out.println("[Consumer] Consumed: " + item);
            isNotFull.signal();

            return item;
        } finally {
            lock.unlock();
        }
    }
}

public class ConditionVariables {
    public static void main(String[] args) {
        ConditionBuffer buffer = new ConditionBuffer();

        Thread prod = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.produce(i);
                    Thread.sleep(150);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread cons = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.consume();
                    Thread.sleep(400);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        prod.start();
        cons.start();
    }
}
