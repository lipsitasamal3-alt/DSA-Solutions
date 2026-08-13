/*
---------------------------------------------------------
Problem: Detect Capital

Platform: LeetCode

Difficulty: Easy

Approach:
Strings + Character Case Checking

Valid capitalization patterns:
1. All letters are uppercase
      USA

2. All letters are lowercase
      leetcode

3. Only the first letter is uppercase
      Google

Algorithm:
1. Check if the entire word is uppercase.
2. Check if the entire word is lowercase.
3. Check if the first character is uppercase and all
   remaining characters are lowercase.
4. If none of these conditions are true, return false.

Time Complexity:
O(n)

Space Complexity:
O(n) due to substring/case conversion operations.

Link:
https://leetcode.com/problems/detect-capital/
---------------------------------------------------------
*/

class Solution {

    public boolean detectCapitalUse(String word) {

        // All uppercase
        if (word.toUpperCase().equals(word)) {
            return true;
        }

        // All lowercase
        if (word.toLowerCase().equals(word)) {
            return true;
        }

        // First letter uppercase, remaining lowercase
        if (Character.isUpperCase(word.charAt(0)) &&
            word.substring(1).toLowerCase().equals(word.substring(1))) {

            return true;
        }

        return false;
    }
}