/*
---------------------------------------------------------
Problem: Implement Queue using Stacks

Platform: LeetCode

Difficulty: Easy

Approach:
Two Stacks

Algorithm:
1. Maintain two stacks:
   - inStack for enqueue operations.
   - outStack for dequeue operations.
2. For push(x):
   - Push the element onto inStack.
3. For pop():
   - If outStack is empty, move all elements from inStack to outStack.
   - Pop and return the top element of outStack.
4. For peek():
   - If outStack is empty, move all elements from inStack to outStack.
   - Return the top element of outStack.
5. For empty():
   - Return true if both stacks are empty; otherwise, return false.

Time Complexity:
Push: O(1)
Pop: Amortized O(1)
Peek: Amortized O(1)
Empty: O(1)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/implement-queue-using-stacks/
---------------------------------------------------------
*/

class MyQueue {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {

        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {

        inStack.push(x);
    }

    public int pop() {

        move();
        return outStack.pop();
    }

    public int peek() {

        move();
        return outStack.peek();
    }

    public boolean empty() {

        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void move() {

        if (outStack.isEmpty()) {

            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */