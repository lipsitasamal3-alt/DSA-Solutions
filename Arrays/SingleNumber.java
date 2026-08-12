/*
---------------------------------------------------------
Problem: Single Number

Platform: LeetCode

Difficulty: Easy

Approach:
Arrays + Bit Manipulation (XOR)

Key Idea:
The XOR operator has two important properties:

    x ^ x = 0
    x ^ 0 = x

Therefore, when every number appears twice except one,
all duplicate numbers cancel each other out.

Example:
nums = [4, 1, 2, 1, 2]

4 ^ 1 ^ 2 ^ 1 ^ 2
= 4

The remaining value is the single number.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/single-number/
---------------------------------------------------------
*/

class Solution {

    public int singleNumber(int[] nums) {

        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}