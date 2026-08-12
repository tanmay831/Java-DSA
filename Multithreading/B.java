
class SubThreadB extends Thread {
    public void run() {
        try {
            for (int i = 0; i <= 10; i++) {
                System.out.println("tanmay");
                Thread.sleep(1000);
            }
        } catch (InterruptedException i) {
            i.printStackTrace();
        }
    }
}

public class B {
    public static void main(String[] args) throws InterruptedException {
        SubThreadB t = new SubThreadB();
        t.start();
        for (int i = 0; i <= 10; i++) {
            System.out.println("may");
            Thread.sleep(1000);
        }
    }
} 