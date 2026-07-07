/*
---------------------------------------------------------
Problem: Roman to Integer

Platform: LeetCode

Difficulty: Easy

Approach:
Reverse Traversal

Algorithm:
1. Traverse the Roman numeral from right to left.
2. Convert each Roman character to its integer value.
3. If the current value is smaller than the previous value, subtract it.
4. Otherwise, add it to the total and update the previous value.
5. Return the final integer value.

Time Complexity: O(n)

Space Complexity: O(1)

Link:
https://leetcode.com/problems/roman-to-integer/
---------------------------------------------------------
*/

class Solution {

    public int romanToInt(String s) {

        int total = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            int currentValue = getValue(s.charAt(i));

            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
                prevValue = currentValue;
            }
        }

        return total;
    }

    private int getValue(char c) {

        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}