/*
---------------------------------------------------------
Problem: Add Two Numbers II

Platform: LeetCode

Difficulty: Medium

Approach:
Stack + Linked List

Algorithm:
1. Push all digits of the first linked list into stack1.
2. Push all digits of the second linked list into stack2.
3. Initialize carry as 0 and head as null.
4. While either stack is not empty or carry exists:
   - Pop one digit from each stack (or use 0 if empty).
   - Compute the sum of both digits and the carry.
   - Update the carry.
   - Create a new node with the current digit.
   - Insert the node at the beginning of the result list.
5. Return the head of the resulting linked list.

Time Complexity:
O(n + m)

Space Complexity:
O(n + m)

Link:
https://leetcode.com/problems/add-two-numbers-ii/
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;

        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {

            int value1 = !stack1.isEmpty() ? stack1.pop() : 0;
            int value2 = !stack2.isEmpty() ? stack2.pop() : 0;

            int sum = value1 + value2 + carry;
            carry = sum / 10;

            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
        }

        return head;
    }
}