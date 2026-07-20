/*
---------------------------------------------------------
Problem: Next Greater Node In Linked List

Platform: LeetCode

Difficulty: Medium

Approach:
Monotonic Stack

Algorithm:
1. Traverse the linked list and store all node values in an array list.
2. Initialize:
   - An answer array of the same size.
   - A monotonic decreasing stack to store indices.
3. Traverse the values array from left to right.
4. While the stack is not empty and the current value is greater than
   the value at the index on the top of the stack:
   - Pop the index.
   - Set the corresponding answer to the current value.
5. Push the current index onto the stack.
6. Indices remaining in the stack have no greater value on the right,
   so their answers remain 0.
7. Return the answer array.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/next-greater-node-in-linked-list/
---------------------------------------------------------
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    public int[] nextLargerNodes(ListNode head) {

        List<Integer> values = new ArrayList<>();

        ListNode current = head;

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        int n = values.size();
        int[] answer = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   values.get(stack.peek()) < values.get(i)) {

                int previousIndex = stack.pop();
                answer[previousIndex] = values.get(i);
            }

            stack.push(i);
        }

        return answer;
    }
}