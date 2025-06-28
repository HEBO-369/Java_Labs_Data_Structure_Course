# 🕵️‍♂️ Team Players Detection in a Photo – Java Implementation

## 📌 Overview

This project provides a Java implementation of an algorithm to **detect and locate players** of a specific team in a photo represented as a 2D character grid.

The logic is based on:
- Identifying connected regions of pixels belonging to the specified team
- Calculating their **bounding area**
- Filtering based on a **minimum area threshold**
- Returning the **center coordinates** of valid players, sorted lexicographically

The implementation follows a breadth-first search (BFS) approach and uses a helper `BoundingBox` class to efficiently track player regions.

---

## 🧠 Problem Summary

- **Input:**
  - A 2D grid representing a photo
  - A team number (0–9)
  - A minimum area threshold

- **Task:**
  - Detect all connected components representing players from the given team
  - Discard regions below the threshold
  - Return the center coordinates of all valid players, sorted by `x` then `y`

---

## 🧱 Key Features

- Implements `IPlayersFinder` interface
- Uses BFS to scan the 2D image
- Calculates the **center point** of each detected region
- Filters based on total pixel area (converted to actual area)
- Returns results as `java.awt.Point[]`

---

## 📥 Input Format

1. First line: dimensions of the photo (e.g. `8, 6`)
2. Next N lines: the actual photo grid (strings of digits)
3. One line for the team number (e.g. `3`)
4. One line for the area threshold (e.g. `16`)

---

## 📤 Output Format

A list of player center positions as:

```
[(x1, y1), (x2, y2), ...]
```

Sorted by `x` ascending, and then by `y`.

---


## 👨‍💻 Author

**Mohamed Wahban**  
Computer Engineering Student – Alexandria University  
[GitHub](https://github.com/HEBO-369)

---

## 📝 Notes

- Supports any grid between 1x1 and 50x50 in size
- Efficient for educational and moderate-size test cases
- Can be extended to handle variable-sized teams, diagonals, or irregular shapes
