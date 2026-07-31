class MyException extends Exception {
    public MyException(String s) {
        super(s);
    }
}

public class CustomException {
    public static void main(String args[]) {
        try {
            throw new MyException("This is custom exception message");
        } catch (MyException ex) {
            System.out.println("Caught custom exception");
            System.out.println(ex.getMessage());
        }
    }
}
