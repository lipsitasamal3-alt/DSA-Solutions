/*
---------------------------------------------------------
Problem: Find the Minimum and Maximum Number of Nodes Between Critical Points

Platform: LeetCode

Difficulty: Medium

Approach:
Single Pass Traversal

Algorithm:
1. If the linked list has fewer than three nodes, return {-1, -1}.
2. Traverse the list while keeping track of the previous, current,
   and next nodes.
3. A node is a critical point if:
   - It is a local maximum, or
   - It is a local minimum.
4. Record:
   - The index of the first critical point.
   - The index of the previous critical point.
5. For every new critical point:
   - Update the minimum distance using the previous critical point.
   - Update the maximum distance using the first critical point.
6. If fewer than two critical points exist, return {-1, -1}.
7. Otherwise, return the minimum and maximum distances.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
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

    public int[] nodesBetweenCriticalPoints(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return new int[] { -1, -1 };
        }

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;

        int firstCriticalIndex = -1;
        int previousCriticalIndex = -1;

        ListNode previous = head;
        ListNode current = head.next;

        int currentIndex = 1;

        while (current.next != null) {

            ListNode nextNode = current.next;

            boolean isMaxima =
                    current.val > previous.val &&
                    current.val > nextNode.val;

            boolean isMinima =
                    current.val < previous.val &&
                    current.val < nextNode.val;

            if (isMaxima || isMinima) {

                if (firstCriticalIndex == -1) {

                    firstCriticalIndex = currentIndex;

                } else {

                    minDistance = Math.min(
                            minDistance,
                            currentIndex - previousCriticalIndex
                    );

                    maxDistance = currentIndex - firstCriticalIndex;
                }

                previousCriticalIndex = currentIndex;
            }

            previous = current;
            current = nextNode;
            currentIndex++;
        }

        if (maxDistance == -1) {
            return new int[] { -1, -1 };
        }

        return new int[] { minDistance, maxDistance };
    }
}