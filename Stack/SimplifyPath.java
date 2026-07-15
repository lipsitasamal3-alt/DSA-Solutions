/*
---------------------------------------------------------
Problem: Simplify Path

Platform: LeetCode

Difficulty: Medium

Approach:
Stack (Deque)

Algorithm:
1. Split the path using '/' as the delimiter.
2. Initialize a stack to store valid directory names.
3. Traverse each component:
   - Ignore empty strings and ".".
   - If the component is "..":
     - Remove the last directory from the stack if it exists.
   - Otherwise, push the directory onto the stack.
4. Construct the simplified path by joining all
   directories with '/'.
5. If the stack is empty, return "/".

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/simplify-path/
---------------------------------------------------------
*/

class Solution {

    public String simplifyPath(String path) {

        String[] components = path.split("/");

        Deque<String> stack = new LinkedList<>();

        for (String component : components) {

            if (component.equals("") || component.equals(".")) {
                continue;
            }

            if (component.equals("..")) {

                if (!stack.isEmpty()) {
                    stack.removeLast();
                }

            } else {

                stack.addLast(component);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (String dir : stack) {
            sb.append("/").append(dir);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}