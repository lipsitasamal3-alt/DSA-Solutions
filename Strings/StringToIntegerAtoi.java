/*
---------------------------------------------------------
Problem: String to Integer (atoi)

Platform: LeetCode

Difficulty: Medium

Approach:
String Parsing

Algorithm:
1. Skip leading whitespace.
2. Check for an optional '+' or '-' sign.
3. Parse consecutive digits.
4. Build the integer while checking for overflow.
5. Return the parsed integer with the correct sign.

Time Complexity: O(n)

Space Complexity: O(1)

Link:
https://leetcode.com/problems/string-to-integer-atoi/
---------------------------------------------------------
*/

class Solution {

    public int myAtoi(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        int i = 0;
        int n = s.length();
        int sign = 1;
        long res = 0;

        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i++) == '-') ? -1 : 1;
        }

        while (i < n && Character.isDigit(s.charAt(i))) {

            res = res * 10 + (s.charAt(i++) - '0');

            if (res * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (res * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int) (res * sign);
    }
}