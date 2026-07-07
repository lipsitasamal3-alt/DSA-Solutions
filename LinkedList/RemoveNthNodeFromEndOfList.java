/*
---------------------------------------------------------
Problem: Remove Nth Node From End of List

Platform: LeetCode

Difficulty: Medium

Approach:
Two Pointers (Fast & Slow)

Algorithm:
1. Create a dummy node pointing to the head.
2. Move the fast pointer (n + 1) steps ahead.
3. Move both fast and slow pointers together until the fast pointer reaches the end.
4. The slow pointer will be just before the node to remove.
5. Skip the target node and return the updated list.

Time Complexity: O(n)

Space Complexity: O(1)

Link:
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
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

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode q = new ListNode(0);
        q.next = head;

        ListNode fast = q;
        ListNode slow = q;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return q.next;
    }
}