/*
---------------------------------------------------------
Problem: Decoded String at Index

Platform: LeetCode

Difficulty: Medium

Approach:
Reverse Simulation + Math

Algorithm:
1. Traverse the string and calculate the total decoded length:
   - If the character is a letter, increase size by 1.
   - If the character is a digit, multiply size by that digit.
2. Traverse the string from right to left.
3. At each step:
   - Update k as k % size.
   - If k becomes 0 and the current character is a letter,
     that character is the answer.
4. If the current character is a digit:
   - Divide size by the digit.
5. If the current character is a letter:
   - Decrease size by 1.
6. Return the identified character.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/decoded-string-at-index/
---------------------------------------------------------
*/

class Solution {

    public String decodeAtIndex(String s, int k) {

        long size = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {

            char current = s.charAt(i);

            if (Character.isDigit(current)) {
                size *= (current - '0');
            } else {
                size++;
            }
        }

        for (int i = n - 1; i >= 0; i--) {

            char current = s.charAt(i);

            k %= size;

            if (k == 0 && Character.isLetter(current)) {
                return Character.toString(current);
            }

            if (Character.isDigit(current)) {
                size /= (current - '0');
            } else {
                size--;
            }
        }

        return "";
    }
}