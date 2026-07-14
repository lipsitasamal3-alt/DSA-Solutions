/*
---------------------------------------------------------
Problem: Reverse Linked List

Platform: LeetCode

Difficulty: Easy

Approach:
Recursion

Algorithm:
1. Handle the base case:
   - If the list is empty or has only one node,
     return the head.
2. Recursively reverse the remaining linked list.
3. Make the next node point to the current node.
4. Set the current node's next pointer to null.
5. Return the new head of the reversed list.

Time Complexity:
O(n)

Space Complexity:
O(n) (due to recursion call stack)

Link:
https://leetcode.com/problems/reverse-linked-list/
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

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
}