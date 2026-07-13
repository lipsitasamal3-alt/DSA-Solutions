/*
---------------------------------------------------------
Problem: Power of Three

Platform: LeetCode

Difficulty: Easy

Approach:
Mathematical Iteration

Algorithm:
1. Check if the number is positive.
2. Repeatedly divide the number by 3 while it is divisible by 3.
3. After all possible divisions:
   - If the remaining value is 1, the number is a power of three.
   - Otherwise, it is not.
4. Return the result.

Time Complexity:
O(log₃ n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/power-of-three/
---------------------------------------------------------
*/

class Solution {

    public boolean isPowerOfThree(int n) {

        if (n <= 0) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}