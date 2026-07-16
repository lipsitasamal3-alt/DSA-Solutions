/*
---------------------------------------------------------
Problem: Rotate List

Platform: LeetCode

Difficulty: Medium

Approach:
Linked List

Algorithm:
1. Handle edge cases:
   - Empty list.
   - Single-node list.
   - k = 0.
2. Traverse the list to:
   - Find its length.
   - Locate the tail node.
3. Compute the effective rotations:
   - k = k % length.
4. If k is 0, return the original list.
5. Connect the tail to the head to form a circular list.
6. Move to the new tail:
   - It is (length - k) nodes from the beginning.
7. Set the next node as the new head.
8. Break the circular link.
9. Return the new head.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/rotate-list/
---------------------------------------------------------
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;

        if (k == 0) {
            return head;
        }

        // Form a circular linked list
        tail.next = head;

        int stepsToNewTail = length - k;
        ListNode newTail = head;

        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;

        // Break the circle
        newTail.next = null;

        return newHead;
    }
}