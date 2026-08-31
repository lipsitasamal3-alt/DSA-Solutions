/*
---------------------------------------------------------
Problem: Longest Palindrome

Platform: LeetCode

Difficulty: Easy

Approach:
HashMap + Frequency Counting

Algorithm:
1. Create a HashMap to store the frequency of every
   character in the string.

2. Traverse the string and count how many times each
   character appears.

3. For every character frequency:
   - Add the largest even portion of the frequency to
     `length`.
   - For example, a frequency of 5 contributes 4.

4. If `length` is smaller than the length of the original
   string, there is at least one character with an odd
   frequency.

5. One odd-frequency character can be placed in the center
   of the palindrome, so add 1 to `length`.

6. Return the maximum possible palindrome length.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/longest-palindrome/
---------------------------------------------------------
*/

class Solution {

    public int longestPalindrome(String s) {

        // Store frequency of each character
        Map<Character, Integer> counts = new HashMap<>();

        for (char c : s.toCharArray()) {
            counts.put(
                c,
                counts.getOrDefault(c, 0) + 1
            );
        }

        int length = 0;

        // Use the largest even portion of each frequency
        for (int count : counts.values()) {

            length += (count / 2) * 2;
        }

        // If any characters remain unused, one of them
        // can be placed in the center of the palindrome
        if (length < s.length()) {
            length += 1;
        }

        return length;
    }
}