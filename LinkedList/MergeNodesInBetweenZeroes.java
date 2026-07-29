/*
---------------------------------------------------------
Problem: Merge Nodes in Between Zeros

Platform: LeetCode

Difficulty: Medium

Approach:
Linked List Traversal

Algorithm:
1. Start from the first node after the initial zero.
2. Maintain two pointers:
   - `modify` to store the sum for each segment.
   - `current` to traverse the list.
3. For each group of nodes between two zeros:
   - Compute the sum of all node values.
   - Store the sum in the `modify` node.
4. Move `current` to the next group after the zero.
5. Link the `modify` node to the beginning of the next group.
6. Repeat until the end of the list.
7. Return the node after the initial zero as the new head.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/merge-nodes-in-between-zeros/
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

    public ListNode mergeNodes(ListNode head) {

        ListNode modify = head.next;
        ListNode current = modify;

        while (current != null) {

            int sum = 0;

            while (current.val != 0) {
                sum += current.val;
                current = current.next;
            }

            modify.val = sum;

            current = current.next;
            modify.next = current;
            modify = modify.next;
        }

        return head.next;
    }
}