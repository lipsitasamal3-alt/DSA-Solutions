/*
---------------------------------------------------------
Problem: Find All Anagrams in a String

Platform: LeetCode

Difficulty: Medium

Approach:
Sliding Window + Frequency Array

Algorithm:
1. Create frequency arrays for the characters in `p` and
   the current window of `s`.
2. Add each character of `p` to `pCount`.
3. Maintain a sliding window of size `p.length()` in `s`.
4. Add the current character to `sCount`.
5. If the window becomes larger than `p`, remove the
   leftmost character.
6. Compare both frequency arrays.
7. If they match, add the starting index of the window
   to the result.

Time Complexity:
O(26 × n) = O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/find-all-anagrams-in-a-string/
---------------------------------------------------------
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Store character frequencies of p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // Sliding window over s
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;

            // Remove character outside the window
            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }

            // Check if current window is an anagram of p
            if (matches(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    // Compare frequency arrays
    private boolean matches(int[] pCount, int[] sCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != sCount[i]) {
                return false;
            }
        }

        return true;
    }
}