import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<String> v = new Vector<>();
        v.add("Delhi");
        v.add("Mumbai");
        v.add("Pune");

        System.out.println("Vector elements: " + v);
        System.out.println("Capacity: " + v.capacity());
    }
}
