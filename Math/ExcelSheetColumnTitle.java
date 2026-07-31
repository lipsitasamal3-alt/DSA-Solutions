/*
---------------------------------------------------------
Problem: Excel Sheet Column Title

Platform: LeetCode

Difficulty: Easy

Approach:
Math

Algorithm:
1. Initialize an empty StringBuilder.
2. While the column number is greater than 0:
   - Decrement the column number by 1 to handle 1-based indexing.
   - Compute the current character using modulo 26.
   - Append the corresponding uppercase letter.
   - Divide the column number by 26 to move to the next digit.
3. Reverse the constructed string.
4. Return the resulting Excel column title.

Time Complexity:
O(log26(n))

Space Complexity:
O(log26(n))

Link:
https://leetcode.com/problems/excel-sheet-column-title/
---------------------------------------------------------
*/

class Solution {

    public String convertToTitle(int columnNumber) {

        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {

            columnNumber--;

            char currentCharacter = (char) ('A' + (columnNumber % 26));
            result.append(currentCharacter);

            columnNumber /= 26;
        }

        return result.reverse().toString();
    }
}