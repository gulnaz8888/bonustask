## KMP String Matching Algorithm — Full Implementation, Tests, Benchmark & Analysis

This project contains a complete from-scratch implementation of the Knuth–Morris–Pratt (KMP) string-matching algorithm in Java.
The repository includes implementation, test cases, benchmarking, JSON-based automated tests, runtime graphs, and a full time/space complexity analysis.

---

## Project Overview

The KMP algorithm efficiently finds all occurrences of a pattern in a text in linear time, using the LPS (Longest Prefix Suffix) table to avoid redundant comparisons.

This project demonstrates:
- How KMP works internally
- Its behavior on different input sizes
- Real benchmark results
- Comparison to theoretical O(n) growth

--- 

## Implemented Features
- Full KMP implementation (LPS table + search function)
-  Manual tests: short, medium and long strings
-  Benchmark with increasing text sizes
-  JSON-based test loader
-  Automated test case parsing (TestCase, TestCaseLoader)
-  JUnit test suite
-  Real program output saved in sample-output.txt
-  Two graphs:
-  Practical runtime (measured)
-  Theoretical O(n) time growth

--- 

## Example Tests

### Short Test
```
text    = ababa
pattern = aba
matches = [0, 2]
```
### Medium Test
```
text    = abcxabcdabxabcdabcdabcy
pattern = abcdabcy
matches = [15]
```
### Long Test
```
text    = aaaaabaaaaabaaaaabaaaaabaaaaab
pattern = aaaaab
matches = [0, 6, 12, 18, 24]
```

---

## Benchmark (Manual Input Sizes)
```
=== benchmark (manual sizes) ===
n = 1000
text length = 1000
pattern = AAAB
matches = [996]
time (ms) = 0.1101

n = 10000
text length = 10000
pattern = AAAB
matches = [9996]
time (ms) = 1.2714

n = 100000
text length = 100000
pattern = AAAB
matches = [99996]
time (ms) = 4.4624

n = 500000
text length = 500000
pattern = AAAB
matches = [499996]
time (ms) = 1.5890

```
---

## Benchmark (JSON Test Cases)
```
=== benchmark (from json) ===
n = 10        pattern = abc    time(ms) = 0    matches = 1
n = 100       pattern = abc    time(ms) = 0    matches = 1
n = 1000      pattern = abc    time(ms) = 0    matches = 1
n = 10000     pattern = abc    time(ms) = 0    matches = 1
n = 100000    pattern = abc    time(ms) = 1    matches = 1
n = 500000    pattern = abc    time(ms) = 5    matches = 1
n = 1000000   pattern = abc    time(ms) = 1    matches = 1

```

---
## Practical Runtime Graph

/images/KMP_Practical_Graphic.png

---

## Theoretical Complexity Graph (O(n))

/images/KMP_Theory_Graphic.png

---


## Time and Space Complexity Analysis

**Time Complexity**
- Building the LPS table: O(m)
- Searching through the text: O(n)
- Total:
O(n + m)

**Space Complexity**
- LPS array: O(m)
- No extra allocations besides counters
- Total memory usage:
O(m)

--- 

## sample-output.txt

The file contains the complete, real output of the program and is included in the repository:

/sample-output.txt

---

## Project Structure
```
src/
└── main/java/org/example/kmp/
├── KmpMatcher.java
├── TestCase.java
├── TestCaseLoader.java
└── Main.java

src/test/java/org/example/kmp/
└── KmpMatcherTest.java

resources/
└── tests.json

images/
├── KMP_Practical_Graphic.png
└── KMP_Theory_Graphic.png

sample-output.txt
readme.md

```
--- 

## Summary

This project fully implements the KMP algorithm, analyzes its behavior under different conditions, measures real runtime on large input sizes, and visualizes both practical and theoretical growth.
All results, tests, graphs, and code are included for transparency and reproducibility.

Author: Eskermes Gylnaz
Group : Se-2438
