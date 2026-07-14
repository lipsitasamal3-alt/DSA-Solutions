/*
---------------------------------------------------------
Problem: Basic Calculator

Platform: LeetCode

Difficulty: Hard

Approach:
Stack

Algorithm:
1. Initialize:
   - A stack to store previous results and signs.
   - currentResult = 0.
   - currentSign = 1.
2. Traverse each character in the string.
3. If the character is a digit:
   - Parse the complete number.
   - Add it to the current result using the current sign.
4. If the character is '+' or '-':
   - Update the current sign.
5. If the character is '(':
   - Push the current result and sign onto the stack.
   - Reset the current result and sign.
6. If the character is ')':
   - Pop the sign and previous result.
   - Combine them with the current result.
7. Return the final result.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/basic-calculator/
---------------------------------------------------------
*/

class Solution {

    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int currentResult = 0;
        int currentSign = 1;
        int len = s.length();

        for (int i = 0; i < len; i++) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {

                int currentNumber = 0;

                while (i < len && Character.isDigit(s.charAt(i))) {

                    currentNumber = currentNumber * 10 + (s.charAt(i) - '0');
                    i++;
                }

                i--;

                currentResult += currentSign * currentNumber;

            } else if (ch == '+') {

                currentSign = 1;

            } else if (ch == '-') {

                currentSign = -1;

            } else if (ch == '(') {

                stack.push(currentResult);
                stack.push(currentSign);

                currentResult = 0;
                currentSign = 1;

            } else if (ch == ')') {

                int parenthesisSign = stack.pop();
                int previousResult = stack.pop();

                currentResult = previousResult + (parenthesisSign * currentResult);
            }
        }

        return currentResult;
    }
}