/*
---------------------------------------------------------
Problem: Swap Nodes in Pairs

Platform: LeetCode

Difficulty: Medium

Approach:
Linked List (Pointer Manipulation)

Algorithm:
1. Create a dummy node pointing to the head.
2. Initialize a pointer (prev) to the dummy node.
3. While two consecutive nodes exist:
   - Identify the first and second nodes.
   - Update pointers to swap them.
   - Move prev to the end of the swapped pair.
4. Return the node following the dummy as the new head.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/swap-nodes-in-pairs/
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

    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {

            ListNode first = prev.next;
            ListNode second = prev.next.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first;
        }

        return dummy.next;
    }
}