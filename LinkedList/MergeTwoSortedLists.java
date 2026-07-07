/*
---------------------------------------------------------
Problem: Merge Two Sorted Lists

Platform: LeetCode

Difficulty: Easy

Approach:
Iterative Merge

Algorithm:
1. Create a dummy node to simplify list construction.
2. Compare the current nodes of both linked lists.
3. Append the smaller node to the merged list.
4. Move the corresponding pointer forward.
5. After one list is exhausted, append the remaining nodes of the other list.
6. Return the merged list starting from dummy.next.

Time Complexity: O(n + m)

Space Complexity: O(1)

Where:
n = Length of list1
m = Length of list2

Link:
https://leetcode.com/problems/merge-two-sorted-lists/
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;
        }

        tail.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }
}