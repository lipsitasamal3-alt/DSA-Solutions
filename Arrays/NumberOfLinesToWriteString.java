/*
---------------------------------------------------------
Problem: Number of Lines To Write String

Platform: LeetCode

Difficulty: Easy

Approach:
Greedy + String Traversal

Algorithm:
1. Start with one line and a current line width of 0.

2. Traverse every character in the string.

3. Find the width of the current character using:
   widths[s.charAt(i) - 'a'].

4. If adding the character would make the current line
   exceed 100 pixels:
   - Start a new line.
   - Set the current width to the character's width.

5. Otherwise, add the character's width to the current line.

6. Return the total number of lines and the width of the
   last line.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/number-of-lines-to-write-string/
---------------------------------------------------------
*/

class Solution {

    public int[] numberOfLines(int[] widths, String s) {

        int lines = 1;
        int currentWidth = 0;

        // Traverse every character in the string
        for (int i = 0; i < s.length(); i++) {

            // Get the width of the current character
            int charWidth = widths[s.charAt(i) - 'a'];

            // Start a new line if width exceeds 100
            if (currentWidth + charWidth > 100) {

                lines++;
                currentWidth = charWidth;

            } else {

                currentWidth += charWidth;
            }
        }

        // Return number of lines and width of the last line
        return new int[]{lines, currentWidth};
    }
}