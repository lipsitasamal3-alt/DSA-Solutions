/*
---------------------------------------------------------
Problem: Longest Repeating Character Replacement

Platform: LeetCode

Difficulty: Medium

Approach:
Sliding Window + Frequency Array

Algorithm:
1. Use a frequency array to count occurrences of each character.
2. Maintain a sliding window using `left` and `right`.
3. Track the highest frequency character in the current window.
4. The number of replacements needed is:
   window length - maximum frequency.
5. If replacements exceed `k`, shrink the window from the left.
6. Track the maximum valid window length.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/longest-repeating-character-replacement/
---------------------------------------------------------
*/

class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];

        int maxFreq = 0;
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            // Update frequency of the current character
            count[s.charAt(right) - 'A']++;

            // Track the most frequent character in the window
            maxFreq = Math.max(
                maxFreq,
                count[s.charAt(right) - 'A']
            );

            // Shrink window if more than k replacements are needed
            if ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // Update maximum valid window length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}