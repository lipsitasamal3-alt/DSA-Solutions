/*
---------------------------------------------------------
Problem: Remove Outermost Parentheses

Platform: LeetCode

Difficulty: Easy

Approach:
Depth Counting

Algorithm:
1. Initialize an empty string builder and a counter for opened parentheses.
2. Traverse the string character by character.
3. If the current character is '(':
   - If the current depth is greater than 0, append it to the result.
   - Increase the depth.
4. If the current character is ')':
   - Decrease the depth.
   - If the new depth is greater than 0, append it to the result.
5. Continue until all characters are processed.
6. Return the resulting string.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/remove-outermost-parentheses/
---------------------------------------------------------
*/

class Solution {

    public String removeOuterParentheses(String s) {

        StringBuilder result = new StringBuilder();
        int opened = 0;

        for (char current : s.toCharArray()) {

            if (current == '(') {

                if (opened > 0) {
                    result.append(current);
                }

                opened++;

            } else {

                opened--;

                if (opened > 0) {
                    result.append(current);
                }
            }
        }

        return result.toString();
    }
}