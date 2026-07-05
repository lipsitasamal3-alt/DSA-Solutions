/*
---------------------------------------------------------
Problem: Add Two Numbers

Platform: LeetCode

Difficulty: Medium

Approach:
Iterative (Dummy Node + Carry)

Algorithm:
1. Create a dummy node to simplify list construction.
2. Traverse both linked lists simultaneously.
3. Add corresponding digits along with the carry.
4. Create a new node with the digit (sum % 10).
5. Update the carry (sum / 10).
6. Continue until both lists and carry are exhausted.

Time Complexity: O(max(m, n))

Space Complexity: O(max(m, n))
(Excluding the output linked list)

Link:
https://leetcode.com/problems/add-two-numbers/
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return dummy.next;
    }
}