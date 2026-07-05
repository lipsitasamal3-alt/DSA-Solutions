/*
---------------------------------------------------------
Problem: Longest Common Prefix

Platform: LeetCode

Difficulty: Easy

Approach:
Horizontal Scanning

Algorithm:
1. Assume the first string is the common prefix.
2. Compare the prefix with each subsequent string.
3. While the current string does not start with the prefix, remove the last character from the prefix.
4. If the prefix becomes empty, return an empty string.
5. After checking all strings, return the remaining prefix.

Time Complexity: O(n × m)
where n = number of strings and m = length of the shortest string

Space Complexity: O(1)

Link:
https://leetcode.com/problems/longest-common-prefix/
---------------------------------------------------------
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}