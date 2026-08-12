/**
 * SynchronizedMethod.java
 * 
 * Demonstrates Race Conditions and fixing them using Synchronized Methods.
 * 
 * Key Concepts:
 * 1. Race Condition: Occurs when multiple threads access and modify shared data simultaneously.
 * 2. 'synchronized' keyword ensures that only ONE thread can execute the method at a time on the same instance.
 */

class SynchronizedBankAccount {
    private int balance = 1000;

    public synchronized void withdraw(int amount, String threadName) {
        if (balance >= amount) {
            System.out.println(threadName + " is about to withdraw $" + amount + ". Current Balance: $" + balance);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println("--> " + threadName + " successfully withdrew $" + amount + ". Remaining Balance: $" + balance);
        } else {
            System.out.println("x " + threadName + " attempted to withdraw $" + amount + " but INSUFFICIENT FUNDS! Balance: $" + balance);
        }
    }

    public int getBalance() {
        return balance;
    }
}

public class SynchronizedMethod {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedBankAccount account = new SynchronizedBankAccount();

        Thread user1 = new Thread(() -> account.withdraw(700, "Alice"));
        Thread user2 = new Thread(() -> account.withdraw(700, "Bob"));

        user1.start();
        user2.start();

        user1.join();
        user2.join();

        System.out.println("\nFinal Account Balance: $" + account.getBalance());
    }
}
