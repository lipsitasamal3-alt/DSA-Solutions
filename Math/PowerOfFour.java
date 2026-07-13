/*
---------------------------------------------------------
Problem: Power of Four

Platform: LeetCode

Difficulty: Easy

Approach:
Mathematical Iteration

Algorithm:
1. Check if the number is positive.
2. Repeatedly divide the number by 4 while it is divisible
   by 4.
3. After all possible divisions:
   - If the remaining value is 1, the number is a power of four.
   - Otherwise, it is not.
4. Return the result.

Time Complexity:
O(log₄ n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/power-of-four/
---------------------------------------------------------
*/

class Solution {

    public boolean isPowerOfFour(int n) {

        if (n <= 0) {
            return false;
        }

        while (n % 4 == 0) {
            n /= 4;
        }

        return n == 1;
    }
}