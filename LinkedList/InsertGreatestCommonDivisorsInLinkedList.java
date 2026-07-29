/*
---------------------------------------------------------
Problem: Insert Greatest Common Divisors in Linked List

Platform: LeetCode

Difficulty: Medium

Approach:
Linked List Traversal + Euclidean Algorithm

Algorithm:
1. If the list has fewer than two nodes, return the head.
2. Traverse the linked list.
3. For every pair of adjacent nodes:
   - Compute their Greatest Common Divisor (GCD).
   - Create a new node containing the GCD.
   - Insert the new node between the two original nodes.
4. Move to the next original node.
5. Continue until the end of the list.
6. Return the modified head.

Time Complexity:
O(n × log(maxValue))

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/
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

    public ListNode insertGreatestCommonDivisors(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;

        while (current != null && current.next != null) {

            int gcdValue = gcd(current.val, current.next.val);

            ListNode gcdNode = new ListNode(gcdValue, current.next);
            current.next = gcdNode;

            current = gcdNode.next;
        }

        return head;
    }

    private int gcd(int a, int b) {

        while (b != 0) {

            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}