# 📚 Data Structures I – Assignment 6  
**Queue Implementation (Linked & Array-based)**

---

## 📌 Objectives

This assignment aims to help students:
1. Implement the **Queue** data structure using:
   - Linked List (linked-based representation)
   - Array (array-based representation)
2. Understand the core behavior and properties of queues (FIFO).
3. Perform proper **testing using JUnit**.
4. Work in **teams** using custom-built data structures.

---

## 🧱 Interface Specification

You must implement the following interface in **both representations**:

```java
public interface IQueue {
  void enqueue(Object item);   // Inserts an item at the queue front
  Object dequeue();            // Removes the object at the queue rear
  boolean isEmpty();           // Tests if queue is empty
  int size();                  // Returns the number of elements in the queue
}
```

---

## 🧩 Queue Implementations

### 1️⃣ Linked-Based Queue  
**Marker Interface:**  
```java
public interface ILinkedBased {}
```

- Use a singly or doubly linked list for internal structure.
- Dynamic in size (no max limit).
- Maintain `front` and `rear` pointers for efficiency.
- Handle edge cases: dequeue from empty queue, etc.

---

### 2️⃣ Array-Based Queue  
**Marker Interface:**  
```java
public interface IArrayBased {}
```

- Use a fixed-size array defined by constructor parameter `n`.
- Implement circular queue logic (recommended).
- Handle overflow and underflow cases correctly.
- Maintain `front`, `rear`, and `count` variables for efficiency.

---

## 🧪 Testing

- ✅ You are required to write **JUnit test cases** to validate the functionality of both implementations.
- Test cases must include:
  - Enqueueing and dequeueing behavior
  - Edge cases (empty/full queues)
  - Correct `size()` updates
  - Input validation (if applicable)

---

## 🧷 Deliverables

- `LinkedQueue.java`: Queue implemented using Linked List.
- `ArrayQueue.java`: Queue implemented using Array.
- `IQueue.java`: Interface with full required methods.
- `ILinkedBased.java`: Marker for linked version.
- `IArrayBased.java`: Marker for array version.
- `QueueTest.java`: JUnit test class for both implementations.

---
## 👨‍👩‍👧‍👦 Team Members
	- **Mohamed Wahban**
	- **Anas Mahmoud**

## 👨‍💻 Author

**Mohamed Wahban**  
Computer and Systems Engineering  
Alexandria University  
GitHub: [HEBO-369](https://github.com/HEBO-369)

---
