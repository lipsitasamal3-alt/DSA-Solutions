/*
---------------------------------------------------------
Problem: Basic Calculator II

Platform: LeetCode

Difficulty: Medium

Approach:
Stack

Algorithm:
1. Initialize:
   - A stack to store intermediate values.
   - currentNumber = 0.
   - operator = '+'.
2. Traverse the expression character by character.
3. Build multi-digit numbers.
4. When an operator or the end of the string is reached:
   - If operator is '+', push the number.
   - If operator is '-', push the negative number.
   - If operator is '*', multiply with the top of the stack.
   - If operator is '/', divide the top of the stack.
5. Update the current operator.
6. Reset the current number.
7. Sum all values in the stack.
8. Return the final result.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/basic-calculator-ii/
---------------------------------------------------------
*/

class Solution {

    public int calculate(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        int currentNumber = 0;
        char operator = '+';
        int len = s.length();

        for (int i = 0; i < len; i++) {

            char currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + (currentChar - '0');
            }

            if ((!Character.isDigit(currentChar) && currentChar != ' ')
                    || i == len - 1) {

                if (operator == '+') {

                    stack.push(currentNumber);

                } else if (operator == '-') {

                    stack.push(-currentNumber);

                } else if (operator == '*') {

                    stack.push(stack.pop() * currentNumber);

                } else if (operator == '/') {

                    stack.push(stack.pop() / currentNumber);
                }

                operator = currentChar;
                currentNumber = 0;
            }
        }

        int totalSum = 0;

        while (!stack.isEmpty()) {
            totalSum += stack.pop();
        }

        return totalSum;
    }
}