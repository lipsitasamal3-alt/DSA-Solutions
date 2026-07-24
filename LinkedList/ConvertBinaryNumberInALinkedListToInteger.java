/*
---------------------------------------------------------
Problem: Convert Binary Number in a Linked List to Integer

Platform: LeetCode

Difficulty: Easy

Approach:
Bit Manipulation

Algorithm:
1. Initialize the decimal value as 0.
2. Traverse the linked list from head to tail.
3. For each node:
   - Left shift the current decimal value by 1 bit.
   - Add the current node's binary value using bitwise OR.
4. Continue until all nodes are processed.
5. Return the final decimal value.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
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

    public int getDecimalValue(ListNode head) {

        int decimalValue = 0;

        while (head != null) {

            decimalValue = (decimalValue << 1) | head.val;
            head = head.next;
        }

        return decimalValue;
    }
}