/*
---------------------------------------------------------
Problem: Validate Stack Sequences

Platform: LeetCode

Difficulty: Medium

Approach:
Stack Simulation

Algorithm:
1. Initialize an empty stack and a pointer for the popped array.
2. Traverse each element in the pushed array.
3. Push the current element onto the stack.
4. While:
   - The stack is not empty, and
   - The top of the stack matches the current element in the popped array:
     - Pop the top element.
     - Move the popped array pointer to the next element.
5. After processing all pushed elements, the sequences are valid if the stack is empty.
6. Return whether the stack is empty.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/validate-stack-sequences/
---------------------------------------------------------
*/

class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;

        for (int value : pushed) {

            stack.push(value);

            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }

        return stack.isEmpty();
    }
}