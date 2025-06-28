# 🔗 Data Structures I – Assignment 4  
**Linked Lists Implementation & Polynomial Manipulation System**


---

## Part 1️⃣ – Singly Linked List

### ✅ Overview
Implements the `ILinkedList` interface using a classic **singly linked list** structure, where each node points only to the next one.

### 📌 Features
- Dynamic memory allocation
- Sequential node traversal
- Efficient insertion/removal at head
- Basic operations:
  - `add`, `get`, `set`, `remove`, `clear`
  - `size`, `isEmpty`, `contains`, `sublist`

### 📄 File:
`SingleLinkedList.java`

---

## Part 2️⃣ – Doubly Linked List

### ✅ Overview
Implements the same `ILinkedList` interface using a **doubly linked list** where each node has both `next` and `prev` references for easier traversal in both directions.

### 📌 Features
- Bidirectional traversal
- More efficient insert/remove at both ends
- Used when backward navigation is needed
- Implements all required operations of `ILinkedList`

### 📄 File:
`DoubleLinkedList.java`

---

## Part 3️⃣ – Polynomial Solver (Core Application)

### ✅ Overview
A menu-driven system to read, store, and perform arithmetic operations on **polynomials**, using either singly or doubly linked lists for term representation.

Each polynomial is stored as a list of terms ordered by descending exponent. The system supports variables:  
- **A, B, C** → user-defined polynomials  
- **R** → result polynomial of any operation  

### 📘 Interface: `IPolynomialSolver`

```java
void setPolynomial(char poly, int[][] terms);
String print(char poly);
void clearPolynomial(char poly);
float evaluatePolynomial(char poly, float value);
int[][] add(char poly1, char poly2);
int[][] subtract(char poly1, char poly2);
int[][] multiply(char poly1, char poly2);
```

### 🧠 Operations Supported

| Operation | Description |
|----------|-------------|
| **Set Polynomial** | Define polynomial by array of terms `[coefficient, exponent]` |
| **Print** | Display polynomial in standard readable form `e.g., 3x^2 + x - 1` |
| **Add/Subtract/Multiply** | Perform operations between two polynomials and store result in **R** |
| **Evaluate** | Compute value of polynomial at specific `x = value` |
| **Clear** | Remove all terms from a polynomial variable |

---

### ✍️ Sample Input / Output

```java
// Set A
setPolynomial('A', new int[][] {{3, 4}, {-2, 2}, {1, 0}}); // 3x^4 - 2x^2 + 1

// Print A
print('A') => "3x^4 - 2x^2 + 1"

// Set B
setPolynomial('B', new int[][] {{1, 3}, {5, 2}, {2, 0}}); // x^3 + 5x^2 + 2

// Add A + B
add('A', 'B') => R = 3x^4 + x^3 + 3x^2 + 3

// Evaluate R at x = 2
evaluatePolynomial('R', 2) => 3(16) + 8 + 12 + 3 = **71**
```

---

### 🛑 Error Handling

- Throws **RuntimeException** if:
  - Trying to operate on unset or cleared polynomials
  - Invalid polynomial name
  - Malformed input

---

### 🧮 Internal Design

- Each polynomial is represented as a linked list of nodes
  - Each node = one term `[coefficient, exponent]`
  - Ordered descending by exponent
- Operations like add/subtract/multiply are done by traversing term-by-term
- Evaluation uses:  
  `result += coefficient * Math.pow(x, exponent)`

---

## 🧑‍💻 Author

**Mohamed Wahban**  
Computer and Systems Engineering – Alexandria University  
GitHub: [HEBO-369](https://github.com/HEBO-369)

---
