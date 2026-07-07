/*
---------------------------------------------------------
Problem: Letter Combinations of a Phone Number

Platform: LeetCode

Difficulty: Medium

Approach:
Backtracking

Algorithm:
1. Create a mapping of digits to corresponding letters.
2. Start from the first digit.
3. For each possible letter, append it to the current combination.
4. Recursively process the next digit.
5. When all digits are processed, add the combination to the result.

Time Complexity: O(4ⁿ × n)

Space Complexity: O(n)
(Excluding the output list)

Where:
n = Number of digits

Link:
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
---------------------------------------------------------
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    private static final String[] KEYPAD = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return result;
        }

        backtrack(result, digits, "", 0);

        return result;
    }

    private void backtrack(List<String> result, String digits,
                           String current, int index) {

        if (index == digits.length()) {
            result.add(current);
            return;
        }

        String letters = KEYPAD[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            backtrack(result, digits, current + c, index + 1);
        }
    }
}