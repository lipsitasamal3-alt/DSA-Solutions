/*
---------------------------------------------------------
Problem: Remove Linked List Elements

Platform: LeetCode

Difficulty: Easy

Approach:
Linked List (Dummy Node)

Algorithm:
1. Create a dummy node pointing to the head.
2. Initialize a pointer at the dummy node.
3. Traverse the linked list:
   - If the next node's value equals the target value,
     remove it by updating the next pointer.
   - Otherwise, move to the next node.
4. Return the node following the dummy node as the
   updated head.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/remove-linked-list-elements/
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

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = dummy;

        while (curr.next != null) {

            if (curr.next.val == val) {

                curr.next = curr.next.next;

            } else {

                curr = curr.next;
            }
        }

        return dummy.next;
    }
}