import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();
        q.offer("A");
        q.offer("B");
        q.offer("C");

        System.out.println("Queue: " + q);
        System.out.println("Head element: " + q.peek());
        System.out.println("Removed element: " + q.poll());
        System.out.println("Queue after poll: " + q);
    }
}
