/*
---------------------------------------------------------
Problem: Plus One

Platform: LeetCode

Difficulty: Easy

Approach:
Array Traversal

Algorithm:
1. Traverse the array from the last digit to the first.
2. If the current digit is less than 9:
   - Increment it by one.
   - Return the updated array.
3. Otherwise:
   - Set the current digit to 0 and continue.
4. If all digits were 9:
   - Create a new array with one extra digit.
   - Set the first element to 1.
5. Return the new array.

Time Complexity:
O(n)

Space Complexity:
O(1) (or O(n) only when creating a new array)

Link:
https://leetcode.com/problems/plus-one/
---------------------------------------------------------
*/

class Solution {

    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] < 9) {

                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;

        return newDigits;
    }
}