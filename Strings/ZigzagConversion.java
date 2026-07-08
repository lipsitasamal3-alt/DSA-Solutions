/*
---------------------------------------------------------
Problem: Zigzag Conversion

Platform: LeetCode

Difficulty: Medium

Approach:
Simulation

Algorithm:
1. Handle the edge case where numRows is 1 or greater than or equal to the string length.
2. Create a StringBuilder for each row.
3. Traverse the string character by character.
4. Append each character to the current row.
5. Change direction when reaching the first or last row.
6. Concatenate all rows to form the final result.

Time Complexity: O(n)

Space Complexity: O(n)

Link:
https://leetcode.com/problems/zigzag-conversion/
---------------------------------------------------------
*/

class Solution {

    public String convert(String s, int numRows) {

        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {

            rows[currentRow].append(c);

            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}