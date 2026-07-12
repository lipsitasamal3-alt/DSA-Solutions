/*
---------------------------------------------------------
Problem: Length of Last Word

Platform: LeetCode

Difficulty: Easy

Approach:
Reverse Traversal

Algorithm:
1. Start from the end of the string.
2. Skip all trailing spaces.
3. Count the characters of the last word until a space
   or the beginning of the string is reached.
4. Return the count.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/length-of-last-word/
---------------------------------------------------------
*/

class Solution {

    public int lengthOfLastWord(String s) {

        int length = 0;
        int i = s.length() - 1;

        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}