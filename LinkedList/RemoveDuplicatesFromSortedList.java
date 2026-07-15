/*
---------------------------------------------------------
Problem: Remove Duplicates from Sorted List

Platform: LeetCode

Difficulty: Easy

Approach:
Linked List Traversal

Algorithm:
1. Initialize a pointer at the head of the linked list.
2. Traverse the list while the current node and the
   next node exist.
3. If the current node and the next node have the same value:
   - Remove the duplicate node by updating the next pointer.
4. Otherwise:
   - Move to the next node.
5. Return the head of the modified linked list.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/remove-duplicates-from-sorted-list/
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

    public ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;

        while (current != null && current.next != null) {

            if (current.val == current.next.val) {

                current.next = current.next.next;

            } else {

                current = current.next;
            }
        }

        return head;
    }
}