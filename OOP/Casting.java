class Parent {
    public void show() {
        System.out.println("Parent class method");
    }
}

class Child extends Parent {
    public void childSpecial() {
        System.out.println("Child class method");
    }
}

public class Casting {
    public static void main(String[] args) {
        // Upcasting
        Parent p = new Child();
        p.show();

        // Downcasting
        if (p instanceof Child) {
            Child c = (Child) p;
            c.childSpecial();
        }
    }
}
