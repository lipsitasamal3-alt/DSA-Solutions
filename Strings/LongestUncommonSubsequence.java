/*
---------------------------------------------------------
Problem: Longest Uncommon Subsequence I

Platform: LeetCode

Difficulty: Easy

Approach:
Strings + Comparison

Key Idea:
There are only two cases:

1. If a and b are identical:
      No uncommon subsequence exists.
      Return -1.

2. If a and b are different:
      The longer string itself cannot be a subsequence of
      the shorter string, so the answer is simply the length
      of the longer string.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/longest-uncommon-subsequence-i/
---------------------------------------------------------
*/

class Solution {

    public int findLUSlength(String a, String b) {

        if (a.equals(b)) {
            return -1;
        }

        return Math.max(a.length(), b.length());
    }
}