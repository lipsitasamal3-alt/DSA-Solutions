/*
---------------------------------------------------------
Problem: Clumsy Factorial

Platform: LeetCode

Difficulty: Medium

Approach:
Math

Algorithm:
1. Handle the base cases for n = 1, 2, 3, and 4 directly.
2. For n > 4, observe the repeating pattern based on n % 4.
3. Return the result using the following cases:
   - If n % 4 == 0:
     Answer = n + 1
   - If n % 4 == 1:
     Answer = n + 2
   - If n % 4 == 2:
     Answer = n + 2
   - If n % 4 == 3:
     Answer = n - 1
4. Return the computed result.

Time Complexity:
O(1)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/clumsy-factorial/
---------------------------------------------------------
*/

class Solution {

    public int clumsy(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (n == 3) {
            return 6;
        }

        if (n == 4) {
            return 7;
        }

        if (n % 4 == 1) {
            return n + 2;
        }

        if (n % 4 == 2) {
            return n + 2;
        }

        if (n % 4 == 3) {
            return n - 1;
        }

        return n + 1;
    }
}