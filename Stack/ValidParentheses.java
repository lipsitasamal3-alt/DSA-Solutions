/*
---------------------------------------------------------
Problem: Valid Parentheses

Platform: LeetCode

Difficulty: Easy

Approach:
Stack with HashMap

Algorithm:
1. Create a HashMap to store matching closing and opening brackets.
2. Initialize an empty stack.
3. Traverse each character in the string.
4. If the character is a closing bracket:
   - Pop the top element from the stack (or use a placeholder if empty).
   - Compare it with the corresponding opening bracket.
   - If they do not match, return false.
5. If the character is an opening bracket:
   - Push it onto the stack.
6. After processing all characters, return true only if the stack is empty.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/valid-parentheses/
---------------------------------------------------------
*/

class Solution {

    public boolean isValid(String s) {

        HashMap<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (map.containsKey(c)) {

                char topElement = stack.isEmpty() ? '#' : stack.pop();

                if (topElement != map.get(c)) {
                    return false;
                }

            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}