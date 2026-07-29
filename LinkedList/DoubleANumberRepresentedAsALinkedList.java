/*
---------------------------------------------------------
Problem: Double a Number Represented as a Linked List

Platform: LeetCode

Difficulty: Medium

Approach:
Linked List Traversal

Algorithm:
1. If the first node's value is at least 5, add a new leading node
   with value 0 to handle a possible carry.
2. Traverse the linked list from left to right.
3. For each node:
   - Double its value and keep only the last digit.
   - If the next node exists and its value is at least 5,
     add the carry (1) to the current node.
4. Continue until the end of the list.
5. Return the head of the modified linked list.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/
---------------------------------------------------------
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) {
 *         this.val = val;
 *     }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    public ListNode doubleIt(ListNode head) {

        if (head.val >= 5) {
            head = new ListNode(0, head);
        }

        ListNode current = head;

        while (current != null) {

            current.val = (current.val * 2) % 10;

            if (current.next != null && current.next.val >= 5) {
                current.val++;
            }

            current = current.next;
        }

        return head;
    }
}