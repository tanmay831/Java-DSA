import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println("Stack: " + st);
        System.out.println("Top element (peek): " + st.peek());
        System.out.println("Popped element: " + st.pop());
        System.out.println("Stack after pop: " + st);
    }
}
