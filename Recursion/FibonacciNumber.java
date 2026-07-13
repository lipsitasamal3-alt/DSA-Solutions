/*
---------------------------------------------------------
Problem: Fibonacci Number

Platform: LeetCode

Difficulty: Easy

Approach:
Recursion

Algorithm:
1. Check the base cases:
   - If n is 0, return 0.
   - If n is 1, return 1.
2. For other values, recursively calculate:
   - Fibonacci(n-1)
   - Fibonacci(n-2)
3. Add both results and return the Fibonacci number.

Time Complexity:
O(2^n)

Space Complexity:
O(n) (due to recursion call stack)

Link:
https://leetcode.com/problems/fibonacci-number/
---------------------------------------------------------
*/

class Solution {

    public int fib(int n) {

        if (n == 0 || n == 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}