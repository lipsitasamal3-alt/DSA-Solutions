/*
---------------------------------------------------------
Problem: Reverse Linked List II

Platform: LeetCode

Difficulty: Medium

Approach:
Linked List (In-place Reversal)

Algorithm:
1. If the list is empty or left equals right, return the head.
2. Create a dummy node pointing to the head.
3. Move a pointer to the node just before the `left` position.
4. Let `current` be the first node of the sublist to reverse.
5. Repeatedly:
   - Remove the node after `current`.
   - Insert it immediately after the previous node.
6. Continue until the sublist from `left` to `right` is reversed.
7. Return `dummy.next` as the new head.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/reverse-linked-list-ii/
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

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode previous = dummy;

        for (int i = 0; i < left - 1; i++) {
            previous = previous.next;
        }

        ListNode current = previous.next;
        ListNode nextNode = current.next;

        for (int i = 0; i < right - left; i++) {

            current.next = nextNode.next;
            nextNode.next = previous.next;
            previous.next = nextNode;
            nextNode = current.next;
        }

        return dummy.next;
    }
}