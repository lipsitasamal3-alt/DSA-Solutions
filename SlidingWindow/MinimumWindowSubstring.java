/*
---------------------------------------------------------
Problem: Minimum Window Substring

Platform: LeetCode

Difficulty: Hard

Approach:
Sliding Window + Frequency Array

Algorithm:
1. Create a frequency array `map` to store the number of
   times each character appears in string `t`.

2. Maintain two pointers:
   - `left`  → start of the current window.
   - `right` → end of the current window.

3. Maintain `count` as the number of characters from `t`
   that are still required in the current window.

4. Expand the window by moving `right`:
   - If the current character is still required,
     decrease `count`.
   - Decrease its frequency in `map`.

5. When `count == 0`, the current window contains all
   characters required by `t`.

6. Try to shrink the window from the left while keeping
   it valid.

7. Whenever a smaller valid window is found, store its
   starting position and length.

8. If removing the left character makes the window invalid,
   move `left` forward and continue expanding the window.

9. Return the smallest valid window. If no valid window
   exists, return an empty string.

Time Complexity:
O(n + m)

Space Complexity:
O(1)
(The frequency array has a fixed size of 128.)

Link:
https://leetcode.com/problems/minimum-window-substring/
---------------------------------------------------------
*/

class Solution {

    public String minWindow(String s, String t) {

        // If t is longer than s, no valid window exists
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Store required character frequencies
        int[] map = new int[128];

        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int left = 0;
        int right = 0;

        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        // Number of characters still required
        int count = t.length();

        // Expand the sliding window
        while (right < s.length()) {

            char rightChar = s.charAt(right);

            // Current character satisfies a required character
            if (map[rightChar] > 0) {
                count--;
            }

            map[rightChar]--;
            right++;

            // Try to shrink the window
            while (count == 0) {

                // Update the minimum window
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }

                char leftChar = s.charAt(left);

                // Remove the left character from the window
                map[leftChar]++;

                // If it becomes required again, the window
                // is no longer valid
                if (map[leftChar] > 0) {
                    count++;
                }

                left++;
            }
        }

        // Return the minimum window if one exists
        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(minStart, minStart + minLen);
    }
}