/*
---------------------------------------------------------
Problem: Find Numbers with Even Number of Digits

Platform: LeetCode

Difficulty: Easy

Approach:
Math

Algorithm:
1. Initialize a counter to 0.
2. Traverse each number in the array.
3. For each number:
   - Compute the number of digits using:
       floor(log10(num)) + 1
   - If the digit count is even, increment the counter.
4. Return the counter.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
---------------------------------------------------------
*/

class Solution {

    public int findNumbers(int[] nums) {

        int count = 0;

        for (int num : nums) {

            int digits = (int) Math.log10(num) + 1;

            if (digits % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}