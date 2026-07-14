/*
---------------------------------------------------------
Problem: Reorder List

Platform: LeetCode

Difficulty: Medium

Approach:
Linked List (Fast & Slow Pointers + Reverse + Merge)

Algorithm:
1. Handle edge cases where the list has fewer than
   three nodes.
2. Find the middle of the linked list using slow
   and fast pointers.
3. Split the list into two halves.
4. Reverse the second half of the list.
5. Merge the two halves alternately:
   - First node from the first half.
   - First node from the reversed second half.
6. Continue until all nodes are reordered.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/reorder-list/
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

    public void reorderList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow.next;

        slow.next = null;

        while (curr != null) {

            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        ListNode first = head;
        ListNode second = prev;

        while (second != null) {

            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}