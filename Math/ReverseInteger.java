/*
---------------------------------------------------------
Problem: Reverse Integer

Platform: LeetCode

Difficulty: Medium

Approach:
Mathematical Reversal

Algorithm:
1. Initialize a variable to store the reversed number.
2. Extract the last digit using modulo (%).
3. Append the digit to the reversed number.
4. Remove the last digit from the original number.
5. Check for integer overflow.
6. Return the reversed integer if valid; otherwise return 0.

Time Complexity: O(log₁₀ n)

Space Complexity: O(1)

Link:
https://leetcode.com/problems/reverse-integer/
---------------------------------------------------------
*/

class Solution {

    public int reverse(int x) {

        long res = 0;

        while (x != 0) {

            res = res * 10 + x % 10;
            x /= 10;

            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
        }

        return (int) res;
    }
}