# Java Collections Framework - Comprehensive Study Notes 📦

The **Java Collections Framework** provides architecture to store and manipulate a group of objects. It includes interfaces (`List`, `Set`, `Queue`, `Map`) and classes (`ArrayList`, `LinkedList`, `Vector`, `Stack`, `PriorityQueue`, `HashMap`).

---

## 📌 Table of Contents
1. [Collection Interface Hierarchy](#1-collection-interface-hierarchy)
2. [List Interface & Implementations](#2-list-interface--implementations)
   - [ArrayList](#arraylist)
   - [LinkedList](#linkedlist)
   - [Vector](#vector)
   - [Stack](#stack)
3. [Queue Interface & Implementations](#3-queue-interface--implementations)
   - [Queue & LinkedList](#queue--linkedlist)
   - [ArrayDeque](#arraydeque)
4. [Time Complexity Comparison Table](#4-time-complexity-comparison-table)

---

## 1. Collection Interface Hierarchy

```
                      java.util.Collection
                                |
        +-----------------------+-----------------------+
        |                                               |
  java.util.List                                java.util.Queue
        |                                               |
  +-----+-----+-----+                             +-----+-----+
  |     |     |     |                             |           |
Array LinkedList Vector Stack                   LinkedList ArrayDeque
List
```

---

## 2. List Interface & Implementations
The `List` interface represents an **ordered collection** (sequence) that allows duplicate elements and positional access via index.

### 🔹 ArrayList
- Implemented using a **dynamic resizable array**.
- **Fast Random Access**: $O(1)$ lookup by index.
- **Slow Insertions/Deletions**: $O(N)$ when shifting elements.
- **Non-synchronized** (not thread-safe).

### 🔹 LinkedList
- Implemented using a **doubly linked list**.
- **Fast Insertions/Deletions**: $O(1)$ at head/tail.
- **Slow Access**: $O(N)$ traversal to specific index.
- Implements both `List` and `Deque` interfaces.

### 🔹 Vector
- Implemented using a **dynamic array** similar to `ArrayList`.
- **Synchronized** (thread-safe, but slower performance).
- Legacy class retained for backward compatibility.

### 🔹 Stack
- Extends `Vector` and represents a **LIFO (Last-In, First-Out)** stack.
- Key methods: `push()`, `pop()`, `peek()`, `isEmpty()`.

---

## 3. Queue Interface & Implementations
Represents a **FIFO (First-In, First-Out)** data structure.

- **Key Methods**:
  - `add()` / `offer()`: Insert element.
  - `remove()` / `poll()`: Retrieve and remove head element.
  - `element()` / `peek()`: Retrieve head element without removing.

---

## 4. Time Complexity Comparison Table

| Data Structure | Access (by Index) | Search | Insertion | Deletion |
| :--- | :--- | :--- | :--- | :--- |
| **ArrayList** | $O(1)$ | $O(N)$ | $O(N)$ (amortized $O(1)$ at end) | $O(N)$ |
| **LinkedList** | $O(N)$ | $O(N)$ | $O(1)$ at head/tail | $O(1)$ at head/tail |
| **Vector** | $O(1)$ | $O(N)$ | $O(N)$ | $O(N)$ |
| **Stack** | $O(N)$ | $O(N)$ | $O(1)$ (`push`) | $O(1)$ (`pop`) |
| **Queue** | $O(N)$ | $O(N)$ | $O(1)$ (`offer`) | $O(1)$ (`poll`) |
