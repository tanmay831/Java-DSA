# Java Multithreading & Concurrency - Comprehensive Study Notes 🧵

**Multithreading** in Java is a process of executing multiple threads simultaneously to maximize CPU utilization. A thread is the smallest unit of execution within a process.

---

## 📌 Table of Contents
1. [Thread Lifecycle & States](#1-thread-lifecycle--states)
2. [Ways to Create Threads](#2-ways-to-create-threads)
3. [Thread Synchronization](#3-thread-synchronization)
4. [Inter-Thread Communication](#4-inter-thread-communication)
5. [Lock API vs Synchronized](#5-lock-api-vs-synchronized)
6. [Volatile vs Atomic Variables](#6-volatile-vs-atomic-variables)
7. [Executor Framework & Thread Pools](#7-executor-framework--thread-pools)
8. [Synchronization Utilities](#8-synchronization-utilities)
9. [Deadlocks & Prevention](#9-deadlocks--prevention)

---

## 1. Thread Lifecycle & States

Java defines 6 thread states in `Thread.State` enum:
- **NEW**: Thread created but `start()` not called yet.
- **RUNNABLE**: Executing in JVM or eligible for CPU execution.
- **BLOCKED**: Waiting to acquire a monitor lock.
- **WAITING**: Waiting indefinitely for another thread to perform a particular action (`wait()`, `join()`).
- **TIMED_WAITING**: Waiting for a specified time (`sleep(ms)`, `wait(ms)`, `join(ms)`).
- **TERMINATED**: Finished execution of `run()` method.

---

## 2. Ways to Create Threads

| Method | Syntax | Pros / Cons |
| :--- | :--- | :--- |
| **Extending `Thread` Class** | `class MyThread extends Thread` | ❌ Cannot extend any other class due to single inheritance. |
| **Implementing `Runnable`** | `class MyTask implements Runnable` | ✅ Preferred. Separates task from execution logic; allows inheritance. |
| **Implementing `Callable<V>`** | `class MyTask implements Callable<String>` | ✅ Returns a value and can throw checked exceptions via `Future`. |
| **Lambda Expressions** | `new Thread(() -> System.out.println("Hi"))` | ✅ Concise, modern syntax (Java 8+). |

---

## 3. Thread Synchronization

Preventing race conditions when multiple threads access shared resources.

- **Synchronized Method**: Locks the instance (`this`) or class (`Class.class` if static).
- **Synchronized Block**: Fine-grained locking on a specific monitor object:
  ```java
  synchronized(lockObject) {
      // Critical Section
  }
  ```

---

## 4. Inter-Thread Communication

Threads communicate using shared monitor methods:
- `wait()`: Releases monitor lock and suspends thread until notified.
- `notify()`: Wakes up a single waiting thread.
- `notifyAll()`: Wakes up all waiting threads.

---

## 5. Lock API vs Synchronized

| Feature | `synchronized` Keyword | `ReentrantLock` |
| :--- | :--- | :--- |
| **Lock Acquisition** | Automatic | Explicit (`lock.lock()`) |
| **Lock Release** | Automatic upon block exit | Explicit in `finally` (`lock.unlock()`) |
| **Non-blocking tryLock** | ❌ No | ✅ Yes (`tryLock()`) |
| **Fairness** | ❌ No guarantee | ✅ Optional (`new ReentrantLock(true)`) |
| **Multiple Conditions** | ❌ 1 condition per object | ✅ Multiple `Condition` objects |

---

## 6. Volatile vs Atomic Variables

- **`volatile`**: Guarantees **visibility** across CPU caches by reading/writing directly to main memory. Does NOT guarantee atomicity for compound operations (e.g., `count++`).
- **`AtomicInteger` / `AtomicBoolean`**: Uses hardware-level **Compare-And-Swap (CAS)** for lock-free, thread-safe compound operations.

---

## 7. Executor Framework & Thread Pools

Reuses worker threads to handle task queues efficiently (`java.util.concurrent.Executors`):
- `newFixedThreadPool(int n)`: Fixed number of threads.
- `newCachedThreadPool()`: Creates new threads as needed, reuses idle threads.
- `newSingleThreadExecutor()`: Sequential task execution.
- `newScheduledThreadPool(int n)`: Periodic/delayed task execution.

---

## 8. Synchronization Utilities

- **`CountDownLatch`**: One-time barrier where threads wait until count reaches zero.
- **`CyclicBarrier`**: Reusable barrier where a set of threads wait for each other to reach a common point.
- **`Semaphore`**: Restricts access to a finite number of shared resources using permits.

---

## 9. Deadlocks & Prevention

A **Deadlock** happens when Thread 1 holds Lock A and waits for Lock B, while Thread 2 holds Lock B and waits for Lock A.

### Prevention Strategies:
1. **Consistent Lock Ordering**: Always acquire locks in the exact same global order.
2. **Lock Timeout**: Use `ReentrantLock.tryLock(timeout, timeUnit)` instead of indefinite blocking.
