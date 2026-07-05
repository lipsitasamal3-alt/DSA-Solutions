/*
---------------------------------------------------------
Problem: Merge k Sorted Lists

Platform: LeetCode

Difficulty: Hard

Approach:
Min Heap (Priority Queue)

Algorithm:
1. Create a min heap to store the head of each linked list.
2. Insert the first node of every non-empty list into the heap.
3. Extract the smallest node from the heap.
4. Append it to the merged list.
5. If the extracted node has a next node, insert it into the heap.
6. Repeat until the heap becomes empty.

Time Complexity: O(N log k)

Space Complexity: O(k)

Where:
N = Total number of nodes
k = Number of linked lists

Link:
https://leetcode.com/problems/merge-k-sorted-lists/
---------------------------------------------------------
*/

import java.util.PriorityQueue;

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
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq =
                new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {

            ListNode minNode = pq.poll();

            curr.next = minNode;
            curr = curr.next;

            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        return dummy.next;
    }
}