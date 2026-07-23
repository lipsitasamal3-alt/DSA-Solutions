/*
---------------------------------------------------------
Problem: Odd Even Linked List

Platform: LeetCode

Difficulty: Medium

Approach:
Linked List Pointer Manipulation

Algorithm:
1. If the list is empty or contains only one node, return the head.
2. Initialize:
   - odd pointer at the first node.
   - even pointer at the second node.
   - evenHead to preserve the start of the even-indexed list.
3. While both even and even.next exist:
   - Link the current odd node to the next odd node.
   - Move the odd pointer forward.
   - Link the current even node to the next even node.
   - Move the even pointer forward.
4. Connect the end of the odd list to evenHead.
5. Return the head of the modified list.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/odd-even-linked-list/
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

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = head;
        ListNode odd = oddHead;

        ListNode evenHead = head.next;
        ListNode even = evenHead;

        while (even != null && even.next != null) {

            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return oddHead;
    }
}