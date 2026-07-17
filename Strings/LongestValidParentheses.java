/*
---------------------------------------------------------
Problem: Longest Valid Parentheses

Platform: LeetCode

Difficulty: Hard

Approach:
Two-Pass String Traversal

Algorithm:
1. Initialize left, right, and maxLength.
2. Traverse the string from left to right:
   - Increment left for '('.
   - Increment right for ')'.
   - If left equals right, update maxLength.
   - If right exceeds left, reset both counters.
3. Reset the counters.
4. Traverse the string from right to left:
   - Increment left for '('.
   - Increment right for ')'.
   - If left equals right, update maxLength.
   - If left exceeds right, reset both counters.
5. Return the maximum valid parentheses length.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/longest-valid-parentheses/
---------------------------------------------------------
*/

class Solution {

    public int longestValidParentheses(String s) {

        int left = 0;
        int right = 0;
        int maxLength = 0;

        // Left to Right
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {

                maxLength = Math.max(maxLength, 2 * right);

            } else if (right > left) {

                left = 0;
                right = 0;
            }
        }

        // Right to Left
        left = 0;
        right = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {

                maxLength = Math.max(maxLength, 2 * left);

            } else if (left > right) {

                left = 0;
                right = 0;
            }
        }

        return maxLength;
    }
}