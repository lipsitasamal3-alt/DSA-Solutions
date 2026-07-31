/*
---------------------------------------------------------
Problem: Add Digits

Platform: LeetCode

Difficulty: Easy

Approach:
Math (Digital Root)

Algorithm:
1. If the number is 0, return 0.
2. Otherwise, use the digital root formula:
   - 1 + (num - 1) % 9
3. Return the computed value.

Explanation:
- The digital root of a positive integer can be found directly
  without repeatedly summing its digits.
- This formula works because of the properties of numbers
  modulo 9.

Time Complexity:
O(1)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/add-digits/
---------------------------------------------------------
*/

class Solution {

    public int addDigits(int num) {

        if (num == 0) {
            return 0;
        }

        return 1 + (num - 1) % 9;
    }
}