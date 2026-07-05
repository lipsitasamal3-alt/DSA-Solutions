/*
---------------------------------------------------------
Problem: Longest Palindromic Substring

Platform: LeetCode

Difficulty: Medium

Approach:
Expand Around Center

Algorithm:
1. Treat each character as the center of a palindrome.
2. Expand outward for both odd-length and even-length palindromes.
3. Keep track of the longest palindrome found.
4. Return the longest palindromic substring.

Time Complexity: O(n²)

Space Complexity: O(1)

Link:
https://leetcode.com/problems/longest-palindromic-substring/
---------------------------------------------------------
*/

class Solution {

    public String longestPalindrome(String s) {

        if (s == null || s.length() < 1)
            return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            int len1 = expandAroundCenter(s, i, i);

            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return right - left - 1;
    }
}