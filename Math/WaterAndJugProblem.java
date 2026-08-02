/*
---------------------------------------------------------
Problem: Water and Jug Problem

Platform: LeetCode

Difficulty: Medium

Approach:
Math (Bézout's Identity)

Algorithm:
1. If the target is greater than the total capacity of both jugs,
   return false.
2. Compute the Greatest Common Divisor (GCD) of the two jug
   capacities using the Euclidean algorithm.
3. According to Bézout's Identity:
   - A target volume can be measured if and only if it is a
     multiple of gcd(x, y).
4. Return whether target % gcd(x, y) == 0.

Time Complexity:
O(log(min(x, y)))

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/water-and-jug-problem/
---------------------------------------------------------
*/

class Solution {

    public boolean canMeasureWater(int x, int y, int target) {

        if (target > x + y) {
            return false;
        }

        return target % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {

        while (b != 0) {

            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}