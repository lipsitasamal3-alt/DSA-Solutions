/*
---------------------------------------------------------
Problem: Parsing A Boolean Expression

Platform: LeetCode

Difficulty: Hard

Approach:
Stack

Algorithm:
1. Traverse the expression character by character.
2. Ignore commas.
3. Push every character except ')' onto the stack.
4. When ')' is encountered:
   - Pop all boolean values until '(' is found.
   - Store the popped values in a set.
   - Remove '(' and pop the corresponding operator.
5. Evaluate the sub-expression:
   - '!' → Negate the single boolean value.
   - '&' → True only if no false value exists.
   - '|' → True if at least one true value exists.
6. Push the evaluated result ('t' or 'f') back onto the stack.
7. After processing the entire expression, return whether the top of the stack is 't'.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/parsing-a-boolean-expression/
---------------------------------------------------------
*/

class Solution {

    public boolean parseBoolExpr(String expression) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {

            char current = expression.charAt(i);

            if (current == ',') {
                continue;
            }

            if (current != ')') {
                stack.push(current);
            } else {

                HashSet<Character> values = new HashSet<>();

                while (stack.peek() != '(') {
                    values.add(stack.pop());
                }

                stack.pop();

                char operator = stack.pop();

                if (operator == '!') {
                    stack.push(values.contains('f') ? 't' : 'f');
                } else if (operator == '&') {
                    stack.push(values.contains('f') ? 'f' : 't');
                } else {
                    stack.push(values.contains('t') ? 't' : 'f');
                }
            }
        }

        return stack.peek() == 't';
    }
}