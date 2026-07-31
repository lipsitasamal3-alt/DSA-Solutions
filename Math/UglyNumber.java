/*
---------------------------------------------------------
Problem: Ugly Number

Platform: LeetCode

Difficulty: Easy

Approach:
Math

Algorithm:
1. If the number is less than or equal to 0, return false.
2. Repeatedly divide the number by 2 while it is divisible by 2.
3. Repeatedly divide the number by 3 while it is divisible by 3.
4. Repeatedly divide the number by 5 while it is divisible by 5.
5. If the remaining value is 1, the number is an ugly number.
6. Otherwise, return false.

Time Complexity:
O(log n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/ugly-number/
---------------------------------------------------------
*/

class Solution {

    public boolean isUgly(int n) {

        if (n <= 0) {
            return false;
        }

        int[] factors = {2, 3, 5};

        for (int factor : factors) {

            while (n % factor == 0) {
                n /= factor;
            }
        }

        return n == 1;
    }
}