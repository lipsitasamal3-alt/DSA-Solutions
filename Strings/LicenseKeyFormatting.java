/*
---------------------------------------------------------
Problem: License Key Formatting

Platform: LeetCode

Difficulty: Easy

Approach:
Strings + Reverse Traversal

Algorithm:
1. Traverse the string from right to left.
2. Ignore existing '-' characters.
3. Add characters to the StringBuilder in uppercase.
4. After every k characters, insert '-'.
5. Reverse the StringBuilder at the end because we built
   the answer from right to left.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/license-key-formatting/
---------------------------------------------------------
*/

class Solution {

    public String licenseKeyFormatting(String s, int k) {

        StringBuilder sb = new StringBuilder();
        int charCount = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            // Ignore existing hyphens
            if (ch == '-') {
                continue;
            }

            // Add hyphen after every k characters
            if (charCount > 0 && charCount % k == 0) {
                sb.append('-');
                charCount = 0;
            }

            sb.append(Character.toUpperCase(ch));
            charCount++;
        }

        return sb.reverse().toString();
    }
}