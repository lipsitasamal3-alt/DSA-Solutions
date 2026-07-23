/*
---------------------------------------------------------
Problem: Insertion Sort List

Platform: LeetCode

Difficulty: Medium

Approach:
Insertion Sort (Linked List)

Algorithm:
1. If the list is empty or contains only one node, return it.
2. Create a dummy node to simplify insertions at the beginning.
3. Traverse the original linked list node by node.
4. For each node:
   - Save the next node.
   - Find the correct position in the sorted list.
   - Insert the current node into the sorted list.
5. Move to the next node from the original list.
6. After processing all nodes, return dummy.next.

Time Complexity:
O(n²)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/insertion-sort-list/
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

    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = head;

        while (current != null) {

            ListNode nextNode = current.next;
            ListNode previous = dummy;

            while (previous.next != null && previous.next.val < current.val) {
                previous = previous.next;
            }

            current.next = previous.next;
            previous.next = current;

            current = nextNode;
        }

        return dummy.next;
    }
}