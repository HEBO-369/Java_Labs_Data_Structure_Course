# 🧮 Java Assignment 2 – Array & Recursion Methods

## 📌 Overview

This project contains Java implementations of six fundamental programming exercises focusing on:

- Array manipulation (1D and 2D)
- Conditional logic
- Mathematical operations
- Recursion

The assignment is part of a course practice set and demonstrates practical use of arrays, loops, and method definitions in Java.

---

## 🧠 Problem Descriptions

### 1. `reverse(int[] arr)`
Reverses the elements of a single-dimensional array **in place** without using extra space.

---

### 2. `sumEvenOdd(int[] arr)`
Returns the sum of even and odd numbers in an array as a two-element array:  
`[sumEven, sumOdd]`  
Returns `[0, 0]` if the array is empty.

---

### 3. `average(int[] arr)`
Calculates the average of all array elements.  
Returns `0.0` if the array is empty.

---

### 4. `moveValue(int[] arr, int val)`
Moves all elements equal to a given value `val` to the **end of the array**, while preserving the **relative order** of other elements.

**Example:**  
Input: `[1,2,3,4,5,6,5,5,7,7]`, `val = 5`  
Output: `[1,2,3,4,6,7,7,5,5,5]`

---

### 5. `transpose(int[][] arr)`
Returns the **transpose** of a 2D rectangular array.  
Assumes the input is always rectangular (same number of columns in each row), but it may be empty.

---

### 6. `fibonacci(int n)`
Returns the **n-th term** in the Fibonacci sequence:  
`0, 1, 1, 2, 3, 5, 8, 13, ...`  
This is implemented using **recursion**.

---

## 👨‍💻 Author

**Mohamed Wahban**  
Computer Engineering Student – Alexandria University  
[GitHub](https://github.com/HEBO-369)

---

## 📝 Notes

- These implementations are intended for learning purposes and may be optimized further.
- Exception handling and edge cases (like null arrays) can be added for robustness in future versions.
