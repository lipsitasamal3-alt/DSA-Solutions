/*
---------------------------------------------------------
Problem: Split Linked List in Parts

Platform: LeetCode

Difficulty: Medium

Approach:
Linked List Traversal

Algorithm:
1. Traverse the linked list to count the total number of nodes.
2. Compute:
   - partSize = totalNodes / k
   - extraNodes = totalNodes % k
3. Create an array of size k to store the heads of each part.
4. For each part:
   - Assign the current node as the head.
   - Determine the current part size:
     partSize + 1 for the first extraNodes parts,
     otherwise partSize.
   - Traverse to the last node of the current part.
   - Disconnect the current part from the remaining list.
5. Return the array containing the heads of all parts.

Time Complexity:
O(n)

Space Complexity:
O(k)

Link:
https://leetcode.com/problems/split-linked-list-in-parts/
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

    public ListNode[] splitListToParts(ListNode head, int k) {

        ListNode current = head;
        int totalNodes = 0;

        while (current != null) {
            totalNodes++;
            current = current.next;
        }

        int partSize = totalNodes / k;
        int extraNodes = totalNodes % k;

        ListNode[] result = new ListNode[k];
        current = head;

        for (int i = 0; i < k; i++) {

            result[i] = current;

            int currentPartSize = partSize + (i < extraNodes ? 1 : 0);

            for (int j = 0; j < currentPartSize - 1; j++) {
                if (current != null) {
                    current = current.next;
                }
            }

            if (current != null) {
                ListNode nextNode = current.next;
                current.next = null;
                current = nextNode;
            }
        }

        return result;
    }
}