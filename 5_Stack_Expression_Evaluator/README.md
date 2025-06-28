# 📚 Data Structures I – Assignment 5   
**Stack Implementation & Expression Evaluator**

---


## 📌 Objectives
This assignment focuses on:
1. Implementing the **Stack** data structure manually.
2. Using stacks to **convert infix expressions** to **postfix**.
3. **Evaluating postfix** expressions accurately.
4. Validating input expressions and building a robust evaluator.

---

## Part 1️⃣ – Stack Implementation

### 🔧 Interface: `IStack`

You are required to implement a custom stack class (using your own internal structure, not built-in libraries) that follows this interface:

```java
public interface IStack {
  Object pop();
  Object peek();
  void push(Object element);
  boolean isEmpty();
  int size();
}
```

### ✅ Implementation Highlights
- You must use either:
  - Custom array-based implementation
  - Or your own singly/doubly linked list (from previous assignments)
- Handle all edge cases (e.g., popping from an empty stack should throw an exception)
- Ensure proper testing for all stack methods

---

## Part 2️⃣ – Expression Evaluator Application

This part of the assignment focuses on building a full application that accepts a **symbolic infix expression**, converts it to **postfix**, and evaluates it.

### 🧮 Supported Features
- Operators: `+`, `-`, `*`, `/`
- Fully parenthesized or free-form expressions
- Variables and multi-digit numbers
- Error detection for:
  - Invalid syntax
  - Unbalanced parentheses
  - Unsupported characters

---

## 📐 Expression Evaluation Logic

### 📘 Interface: `IExpressionEvaluator`

```java
public interface IExpressionEvaluator {
  String infixToPostfix(String expression);
  int evaluate(String expression);
}
```

### 🧠 Evaluation Algorithm

- **Infix to Postfix Conversion:**
  - Use a stack for operators and parentheses.
  - Apply operator precedence and associativity rules.
  - Parentheses are handled explicitly.
  - All variables/numbers are appended directly to the output.

- **Postfix Evaluation:**
  - Traverse postfix from left to right.
  - Push operands onto a stack.
  - On operator: pop two operands, apply operation, and push result back.
  - Final result will be at the top of the stack.

---

## ✍️ Example

```
Infix Input:   a * (b + c) * d
Postfix:       a b c + * d *
```

**As values:**

```
Input: 2 * (3 + 4) * 5
Postfix: 2 3 4 + * 5 *
Result: ((3 + 4) × 2) × 5 = 70
```

---

## 🧪 Example: Postfix Evaluation (with numbers)

Given postfix expression:  
```
6 2 / 3 - 4 2 * +
```

| Step | Stack            | Operation      |
|------|------------------|----------------|
| Push 6       | 6                |              |
| Push 2       | 6 2              |              |
| `/`          | 3                | 6 / 2        |
| Push 3       | 3 3              |              |
| `-`          | 0                | 3 - 3        |
| Push 4       | 0 4              |              |
| Push 2       | 0 4 2            |              |
| `*`          | 0 8              | 4 * 2        |
| `+`          | 8                | 0 + 8        |
| ✅ Result    | **8**            | Final output |

---

## 🧷 Input Validation

Your program **must validate** every user input:

- Unbalanced parentheses → ❌
- Unsupported characters → ❌
- Division by zero → ❌
- Missing operands/operators → ❌
- Empty expressions → ❌

Appropriate exceptions and messages should be shown without crashing the program.

---

## 🧰 Deliverables

- ✅ Custom `IStack` implementation (no Java built-in structures allowed)
- ✅ Full `IExpressionEvaluator` implementation
- ✅ Working `main()` method to test conversion and evaluation
- ✅ JavaDoc comments for all classes, methods, and variables
- ✅ Generated documentation using `javadoc`
- ✅ Fully validated user inputs
- ✅ Clean, modular, and maintainable code

---

## 🚫 Restrictions

- ❌ Do not use built-in `Stack`, `Deque`, `ArrayList`, etc.
- ❌ Do not hardcode parsing logic — always follow precedence rules.
- ❌ Do not copy from other students (strictly penalized)

---

## 👨‍💻 Author

**Mohamed Wahban**  
Computer and Systems Engineering  
Alexandria University  
GitHub: [HEBO-369](https://github.com/HEBO-369)

---
