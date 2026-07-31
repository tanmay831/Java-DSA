# Collections Framework Quick Notes 📦

## 1. List Interface
- Ordered collection, allows duplicates.
- **ArrayList**: Dynamic array. Fast index lookup O(1), slow insertion/deletion O(N).
- **LinkedList**: Doubly linked list. Fast insert/delete at ends O(1), slow index lookup O(N).
- **Vector**: Synchronized (thread-safe) dynamic array.
- **Stack**: LIFO (Last In First Out). Operations: `push()`, `pop()`, `peek()`.

## 2. Queue Interface
- FIFO (First In First Out).
- Implementations: `LinkedList`, `ArrayDeque`.
- Operations: `offer()` (add), `poll()` (remove), `peek()` (view head).
