/*
---------------------------------------------------------
Problem: Score of Parentheses

Platform: LeetCode

Difficulty: Medium

Approach:
Depth Counting (Bit Manipulation)

Algorithm:
1. Initialize score as 0 and depth as 0.
2. Traverse the string character by character.
3. If the current character is '(':
   - Increase the current depth.
4. If the current character is ')':
   - Decrease the current depth.
   - If the previous character was '(':
     - A primitive "()" contributes 2^depth to the score.
     - Add (1 << depth) to the total score.
5. Return the final score.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/score-of-parentheses/
---------------------------------------------------------
*/

class Solution {

    public int scoreOfParentheses(String s) {

        int score = 0;
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                depth++;

            } else {

                depth--;

                if (s.charAt(i - 1) == '(') {
                    score += 1 << depth;
                }
            }
        }

        return score;
    }
}