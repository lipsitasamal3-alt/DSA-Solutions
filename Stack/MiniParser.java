/*
---------------------------------------------------------
Problem: Mini Parser

Platform: LeetCode

Difficulty: Medium

Approach:
Stack

Algorithm:
1. If the input does not begin with '[', it represents a single
   integer, so return it directly.
2. Create a stack to maintain nested lists.
3. Traverse the string character by character:
   - If '[' is encountered, create a new NestedInteger list and
     push it onto the stack.
   - If '-' is encountered, mark the current number as negative.
   - If a digit is encountered, build the current number.
   - If ',' or ']' is encountered:
       - If a number has been formed, add it to the top list.
       - If ']' is encountered and there is more than one list in
         the stack, pop the completed list and add it to its parent.
4. After processing all characters, return the remaining
   NestedInteger from the stack.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/mini-parser/
---------------------------------------------------------
*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation.
 * public interface NestedInteger {
 *     public NestedInteger();
 *     public NestedInteger(int value);
 *     public boolean isInteger();
 *     public Integer getInteger();
 *     public void setInteger(int value);
 *     public void add(NestedInteger ni);
 *     public List<NestedInteger> getList();
 * }
 */

class Solution {

    public NestedInteger deserialize(String s) {

        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        Stack<NestedInteger> stack = new Stack<>();

        int number = 0;
        int sign = 1;
        boolean isNumber = false;

        for (int i = 0; i < s.length(); i++) {

            char current = s.charAt(i);

            if (current == '-') {

                sign = -1;

            } else if (Character.isDigit(current)) {

                number = number * 10 + (current - '0');
                isNumber = true;

            } else if (current == '[') {

                stack.push(new NestedInteger());

            } else if (current == ',' || current == ']') {

                if (isNumber) {

                    stack.peek().add(new NestedInteger(sign * number));

                    number = 0;
                    sign = 1;
                    isNumber = false;
                }

                if (current == ']' && stack.size() > 1) {

                    NestedInteger completedList = stack.pop();
                    stack.peek().add(completedList);
                }
            }
        }

        return stack.peek();
    }
}