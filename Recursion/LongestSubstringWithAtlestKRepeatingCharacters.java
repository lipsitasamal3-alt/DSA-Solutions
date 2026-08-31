/*
---------------------------------------------------------
Problem: Longest Substring with At Least K Repeating
         Characters

Platform: LeetCode

Difficulty: Medium

Approach:
Divide and Conquer + Frequency Counting

Algorithm:
1. If the string length is smaller than `k`, return 0
   because no valid substring can exist.

2. Count the frequency of every character in the string.

3. Traverse the string and find a character whose frequency
   is less than `k`.

4. Such a character cannot be part of any valid substring.
   Therefore, split the string around this character.

5. Recursively find the longest valid substring in each
   resulting part.

6. Take the maximum length among all valid parts.

7. If every character appears at least `k` times, the entire
   string is a valid substring, so return its length.

Time Complexity:
O(n²) in the worst case.

Space Complexity:
O(n)
(Due to recursion and substring creation.)

Link:
https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
---------------------------------------------------------
*/

class Solution {

    public int longestSubstring(String s, int k) {

        // No valid substring can exist
        if (s == null || s.length() < k) {
            return 0;
        }

        // Store frequency of each character
        int[] counts = new int[26];

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        // Find a character that cannot be part of
        // any valid substring
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (counts[c - 'a'] < k) {

                // Split the string around the invalid character
                String[] subStrings = s.split(String.valueOf(c));

                int maxLen = 0;

                // Recursively solve each part
                for (String sub : subStrings) {

                    maxLen = Math.max(
                        maxLen,
                        longestSubstring(sub, k)
                    );
                }

                return maxLen;
            }
        }

        // Every character appears at least k times
        return s.length();
    }
}