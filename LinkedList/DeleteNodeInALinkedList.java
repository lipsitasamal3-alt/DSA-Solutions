/*
---------------------------------------------------------
Problem: Delete Node in a Linked List

Platform: LeetCode

Difficulty: Medium

Approach:
Value Replacement

Algorithm:
1. Copy the value of the next node into the current node.
2. Update the current node's next pointer to skip the next node.
3. The original next node is effectively removed from the linked list.

Time Complexity:
O(1)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/delete-node-in-a-linked-list/
---------------------------------------------------------
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *     }
 * }
 */

class Solution {

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }
}