/*
---------------------------------------------------------
Problem: Implement Stack using Queues

Platform: LeetCode

Difficulty: Easy

Approach:
Queue Simulation (Using Two Queues)

Algorithm:
1. Maintain two queues:
   - q1 stores the current stack elements.
   - q2 is used temporarily during push operations.
2. For push(x):
   - Add x to q2.
   - Move all elements from q1 to q2.
   - Swap q1 and q2 so that the newest element is always at the front.
3. For pop():
   - Remove and return the front element of q1.
4. For top():
   - Return the front element of q1 without removing it.
5. For empty():
   - Return true if q1 is empty; otherwise, return false.

Time Complexity:
Push: O(n)
Pop: O(1)
Top: O(1)
Empty: O(1)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/implement-stack-using-queues/
---------------------------------------------------------
*/

class MyStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {

        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {

        q2.add(x);

        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.remove();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */