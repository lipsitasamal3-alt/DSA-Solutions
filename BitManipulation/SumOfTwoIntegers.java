/*
---------------------------------------------------------
Problem: Sum of Two Integers

Platform: LeetCode

Difficulty: Medium

Approach:
Bit Manipulation

Algorithm:
1. While there is a carry:
   - Compute the sum without carry using XOR.
   - Compute the carry using AND, then shift it left by one bit.
   - Update the operands:
     - a becomes the partial sum.
     - b becomes the carry.
2. When the carry becomes 0, `a` contains the final sum.
3. Return `a`.

Time Complexity:
O(1)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/sum-of-two-integers/
---------------------------------------------------------
*/

class Solution {

    public int getSum(int a, int b) {

        while (b != 0) {

            int sumWithoutCarry = a ^ b;
            int carry = (a & b) << 1;

            a = sumWithoutCarry;
            b = carry;
        }

        return a;
    }
}