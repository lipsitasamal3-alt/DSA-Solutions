/*
---------------------------------------------------------
Problem: Palindrome Linked List

Platform: LeetCode

Difficulty: Easy

Approach:
Linked List (Fast & Slow Pointers + Reverse)

Algorithm:
1. Handle the edge case where the list has zero or one node.
2. Find the middle of the linked list using slow and fast pointers.
3. Reverse the second half of the linked list.
4. Compare the first half with the reversed second half.
5. If any pair of values differs, return false.
6. If all corresponding values match, return true.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/palindrome-linked-list/
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

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow;

        while (curr != null) {

            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        ListNode left = head;
        ListNode right = prev;

        while (right != null) {

            if (left.val != right.val) {
                return false;
            }

            left = left.next;
            right = right.next;
        }

        return true;
    }
}