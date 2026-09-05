/*
---------------------------------------------------------
Problem: Longest Uncommon Subsequence II

Platform: LeetCode

Difficulty: Medium

Approach:
Sorting + Subsequence Checking

Algorithm:
1. Sort the strings in descending order of their length.
2. For each string, check whether it is a subsequence of
   any other string.
3. If it is not a subsequence of any other string, it is
   an uncommon subsequence.
4. Since strings are sorted by length, the first uncommon
   subsequence found has the maximum length.
5. Return its length. If none exists, return -1.

Time Complexity:
O(n² × L)

Space Complexity:
O(log n) for sorting (excluding the input array)

Link:
https://leetcode.com/problems/longest-uncommon-subsequence-ii/
---------------------------------------------------------
*/

class Solution {
    public int findLUSlength(String[] strs) {

        // Sort strings by length in descending order
        Arrays.sort(strs, (a, b) -> Integer.compare(b.length(), a.length()));

        for (int i = 0; i < strs.length; i++) {
            boolean isUncommon = true;

            // Compare with every other string
            for (int j = 0; j < strs.length; j++) {

                if (i == j) {
                    continue;
                }

                // If strs[i] is a subsequence of another string,
                // it cannot be an uncommon subsequence
                if (isSubsequence(strs[i], strs[j])) {
                    isUncommon = false;
                    break;
                }
            }

            // First uncommon string has maximum length
            if (isUncommon) {
                return strs[i].length();
            }
        }

        return -1;
    }

    // Checks whether s1 is a subsequence of s2
    private boolean isSubsequence(String s1, String s2) {
        int i = 0;
        int j = 0;

        while (i < s1.length() && j < s2.length()) {

            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
            }

            j++;
        }

        return i == s1.length();
    }
}