/*
---------------------------------------------------------
Problem: Min Stack

Platform: LeetCode

Difficulty: Medium

Approach:
Stack (Auxiliary Min Stack)

Algorithm:
1. Maintain two stacks:
   - stack: stores all elements.
   - minStack: stores the minimum element corresponding
     to each position.
2. For push:
   - Push the value onto stack.
   - Push the smaller of the current value and the
     current minimum onto minStack.
3. For pop:
   - Pop from both stacks.
4. For top:
   - Return the top element of stack.
5. For getMin:
   - Return the top element of minStack.

Time Complexity:
Push: O(1)
Pop: O(1)
Top: O(1)
GetMin: O(1)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/min-stack/
---------------------------------------------------------
*/

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {

        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {

        stack.push(value);

        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {

        stack.pop();
        minStack.pop();
    }

    public int top() {

        return stack.peek();
    }

    public int getMin() {

        return minStack.peek();
    }
}

