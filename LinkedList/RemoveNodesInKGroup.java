/*
---------------------------------------------------------
Problem: Reverse Nodes in k-Group

Platform: LeetCode

Difficulty: Hard

Approach:
Recursion

Algorithm:
1. Count k nodes from the current position.
2. If fewer than k nodes remain, return the current head.
3. Recursively reverse the remaining list.
4. Reverse the current group of k nodes.
5. Connect the reversed group with the recursively processed list.
6. Return the new head of the reversed group.

Time Complexity: O(n)

Space Complexity: O(n)
(Recursion stack)

Link:
https://leetcode.com/problems/reverse-nodes-in-k-group/
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

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode p = head;
        int count = 0;

        while (p != null && count < k) {
            p = p.next;
            count++;
        }

        if (count == k) {

            p = reverseKGroup(p, k);

            while (count > 0) {
                ListNode nextNode = head.next;
                head.next = p;
                p = head;
                head = nextNode;
                count--;
            }

            head = p;
        }

        return head;
    }
}