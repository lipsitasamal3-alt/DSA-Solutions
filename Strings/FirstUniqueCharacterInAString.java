/*
---------------------------------------------------------
Problem: First Unique Character in a String

Platform: LeetCode

Difficulty: Easy

Approach:
Strings + Frequency Counting

Algorithm:
1. Create an array of size 26 to store the frequency of
   each lowercase English letter.

2. First pass:
   Count how many times each character appears.

3. Second pass:
   Traverse the string from left to right.
   The first character whose frequency is 1 is the answer.

4. If no unique character exists, return -1.

Time Complexity:
O(n)

Space Complexity:
O(1)
(Only 26 character frequencies are stored.)

Link:
https://leetcode.com/problems/first-unique-character-in-a-string/
---------------------------------------------------------
*/

class Solution {

    public int firstUniqChar(String s) {

        int[] charCounts = new int[26];

        // Count character frequencies
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
        }

        // Find first character with frequency 1
        for (int i = 0; i < s.length(); i++) {

            if (charCounts[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}