/*
---------------------------------------------------------
Problem: Excel Sheet Column Number

Platform: LeetCode

Difficulty: Easy

Approach:
Math

Algorithm:
1. Initialize the result as 0.
2. Traverse each character in the column title from left to right.
3. For each character:
   - Convert it to its corresponding value
     ('A' → 1, 'B' → 2, ..., 'Z' → 26).
   - Multiply the current result by 26.
   - Add the current character's value.
4. Return the final column number.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/excel-sheet-column-number/
---------------------------------------------------------
*/

class Solution {

    public int titleToNumber(String columnTitle) {

        int result = 0;

        for (int i = 0; i < columnTitle.length(); i++) {

            int value = columnTitle.charAt(i) - 'A' + 1;
            result = result * 26 + value;
        }

        return result;
    }
}