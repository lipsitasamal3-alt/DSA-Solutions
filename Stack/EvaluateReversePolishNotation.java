/*
---------------------------------------------------------
Problem: Evaluate Reverse Polish Notation

Platform: LeetCode

Difficulty: Medium

Approach:
Stack

Algorithm:
1. Initialize an empty stack.
2. Traverse each token in the input array.
3. If the token is an operator:
   - Pop the top two numbers from the stack.
   - Apply the operator in the correct order (a operator b).
   - Push the result back onto the stack.
4. If the token is a number:
   - Convert it to an integer and push it onto the stack.
5. After processing all tokens, the remaining element on the stack is the final answer.
6. Return the top element.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/evaluate-reverse-polish-notation/
---------------------------------------------------------
*/

class Solution {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/")) {

                int second = stack.pop();
                int first = stack.pop();

                switch (token) {

                    case "+":
                        stack.push(first + second);
                        break;

                    case "-":
                        stack.push(first - second);
                        break;

                    case "*":
                        stack.push(first * second);
                        break;

                    case "/":
                        stack.push(first / second);
                        break;
                }

            } else {

                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}