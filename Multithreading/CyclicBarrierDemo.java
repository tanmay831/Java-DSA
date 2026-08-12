/**
 * CyclicBarrierDemo.java
 * 
 * Demonstrates java.util.concurrent.CyclicBarrier.
 * 
 * Key Concepts:
 * 1. CyclicBarrier allows a set of threads to all wait for each other to reach a common barrier point.
 * 2. Can be reused after waiting threads are released (cyclic).
 * 3. Can execute a barrier action when all threads hit the barrier.
 */

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class GroupTourist implements Runnable {
    private final String name;
    private final CyclicBarrier barrier;

    public GroupTourist(String name, CyclicBarrier barrier) {
        this.name = name;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " arrived at Checkpoint 1.");
            barrier.await();

            System.out.println(name + " arrived at Checkpoint 2.");
            barrier.await();

            System.out.println(name + " reached final destination!");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int numberOfTourists = 3;

        Runnable barrierAction = () -> System.out.println("\n== ALL " + numberOfTourists + " TOURISTS ARRIVED! Proceeding together ==\n");

        CyclicBarrier barrier = new CyclicBarrier(numberOfTourists, barrierAction);

        new Thread(new GroupTourist("Tourist-1", barrier)).start();
        new Thread(new GroupTourist("Tourist-2", barrier)).start();
        new Thread(new GroupTourist("Tourist-3", barrier)).start();
    }
}
