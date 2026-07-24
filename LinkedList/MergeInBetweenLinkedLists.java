/*
---------------------------------------------------------
Problem: Merge In Between Linked Lists

Platform: LeetCode

Difficulty: Medium

Approach:
Linked List Pointer Manipulation

Algorithm:
1. Traverse list1 to reach the node just before index `a`.
2. Continue traversing to find the node immediately after index `b`.
3. Traverse list2 to find its last node.
4. Connect:
   - The node before index `a` to the head of list2.
   - The tail of list2 to the node after index `b`.
5. Return the head of list1.

Time Complexity:
O(n + m)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/merge-in-between-linked-lists/
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

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode previousA = list1;

        for (int i = 0; i < a - 1; i++) {
            previousA = previousA.next;
        }

        ListNode nodeAfterB = previousA;

        for (int i = 0; i < (b - a + 2); i++) {
            nodeAfterB = nodeAfterB.next;
        }

        ListNode tail = list2;

        while (tail.next != null) {
            tail = tail.next;
        }

        previousA.next = list2;
        tail.next = nodeAfterB;

        return list1;
    }
}