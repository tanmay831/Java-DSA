abstract class Vehicle {
    public abstract void start();
    
    public void info() {
        System.out.println("Vehicle abstract class demo");
    }
}

class Bike extends Vehicle {
    public void start() {
        System.out.println("Bike starting with kick...");
    }
}

public class Abstraction {
    public static void main(String args[]) {
        Vehicle v = new Bike();
        v.info();
        v.start();
    }
}
