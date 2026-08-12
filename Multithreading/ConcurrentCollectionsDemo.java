/**
 * ConcurrentCollectionsDemo.java
 * 
 * Demonstrates thread-safe concurrent collections from java.util.concurrent:
 * - ConcurrentHashMap: Lock striping / segment-level thread safety.
 * - CopyOnWriteArrayList: Writes create a fresh copy (ideal for read-heavy operations).
 * - ArrayBlockingQueue: Bounded blocking queue.
 */

import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollectionsDemo {
    public static void main(String[] args) throws InterruptedException {
        // 1. ConcurrentHashMap Demo
        System.out.println("--- 1. ConcurrentHashMap Demo ---");
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("Alice", 90);
        map.put("Bob", 85);
        map.computeIfAbsent("Charlie", key -> 95);

        System.out.println("ConcurrentHashMap content: " + map);

        // 2. CopyOnWriteArrayList Demo
        System.out.println("\n--- 2. CopyOnWriteArrayList Demo ---");
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        for (String fruit : list) {
            System.out.println("Reading: " + fruit);
            if (fruit.equals("Banana")) {
                list.add("Date");
            }
        }
        System.out.println("List after modification during iteration: " + list);

        // 3. BlockingQueue Demo
        System.out.println("\n--- 3. ArrayBlockingQueue Demo ---");
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);

        Thread queueProducer = new Thread(() -> {
            try {
                queue.put("Message 1");
                queue.put("Message 2");
                System.out.println("[Producer] Put 2 items in queue.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread queueConsumer = new Thread(() -> {
            try {
                Thread.sleep(300);
                System.out.println("[Consumer] Took: " + queue.take());
                System.out.println("[Consumer] Took: " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        queueProducer.start();
        queueConsumer.start();

        queueProducer.join();
        queueConsumer.join();
    }
}
