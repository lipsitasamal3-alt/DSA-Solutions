/*
---------------------------------------------------------
Problem: Find the Index of the First Occurrence in a String

Platform: LeetCode

Difficulty: Easy

Approach:
Brute Force using Substring Comparison

Algorithm:
1. Get the lengths of the haystack and needle strings.
2. Traverse the haystack from index 0 to (haystack length - needle length).
3. Extract a substring of length equal to the needle.
4. Compare the substring with the needle.
5. If they are equal, return the current index.
6. If no match is found, return -1.

Time Complexity:
O((n - m + 1) × m)

Space Complexity:
O(m)

Link:
https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
---------------------------------------------------------
*/

class Solution {

    public int strStr(String haystack, String needle) {

        int hLen = haystack.length();
        int nLen = needle.length();

        for (int i = 0; i <= hLen - nLen; i++) {

            if (haystack.substring(i, i + nLen).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}