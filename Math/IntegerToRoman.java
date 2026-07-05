/*
---------------------------------------------------------
Problem: Integer to Roman

Platform: LeetCode

Difficulty: Medium

Approach:
Greedy

Algorithm:
1. Store Roman numeral values and their corresponding symbols.
2. Traverse the values array from largest to smallest.
3. While the current value is less than or equal to the number:
   - Append the corresponding Roman symbol.
   - Subtract the value from the number.
4. Repeat until the number becomes 0.

Time Complexity: O(1)
(The maximum number is 3999, so the number of iterations is constant.)

Space Complexity: O(1)

Link:
https://leetcode.com/problems/integer-to-roman/
---------------------------------------------------------
*/

class Solution {

    public String intToRoman(int num) {

        int[] values = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4, 1
        };

        String[] symbols = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"
        };

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }

        return sb.toString();
    }
}