/*
---------------------------------------------------------
Problem: Power of Two

Platform: LeetCode

Difficulty: Easy

Approach:
Mathematical Iteration

Algorithm:
1. Check if the number is positive.
2. Repeatedly divide the number by 2 while it is divisible
   by 2.
3. After all possible divisions:
   - If the remaining value is 1, the number is a power of two.
   - Otherwise, it is not.
4. Return the result.

Time Complexity:
O(log₂ n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/power-of-two/
---------------------------------------------------------
*/

class Solution {

    public boolean isPowerOfTwo(int n) {

        if (n <= 0) {
            return false;
        }

        while (n % 2 == 0) {
            n /= 2;
        }

        return n == 1;
    }
}