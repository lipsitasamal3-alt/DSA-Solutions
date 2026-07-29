/*
---------------------------------------------------------
Problem: Reverse Nodes in Even Length Groups

Platform: LeetCode

Difficulty: Medium

Approach:
Linked List + Group Reversal

Algorithm:
1. Start from the head and process the linked list in groups of
   increasing size (2, 3, 4, ...).
2. Count the actual number of nodes in the current group.
3. If the group size is even:
   - Reverse all nodes in the current group.
   - Connect the reversed group back to the previous and next parts
     of the list.
4. If the group size is odd:
   - Leave the group unchanged.
5. Move to the next group and increase the expected group size.
6. Continue until all nodes are processed.
7. Return the modified linked list.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/reverse-nodes-in-even-length-groups/
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

    public ListNode reverseEvenLengthGroups(ListNode head) {

        ListNode previous = head;
        int groupLength = 2;

        while (previous != null && previous.next != null) {

            ListNode current = previous.next;

            int nodeCount = 0;
            ListNode temp = current;

            while (temp != null && nodeCount < groupLength) {
                temp = temp.next;
                nodeCount++;
            }

            if (nodeCount % 2 == 0) {

                ListNode reversedPrevious = null;
                ListNode reversedCurrent = current;

                for (int i = 0; i < nodeCount; i++) {

                    ListNode nextNode = reversedCurrent.next;
                    reversedCurrent.next = reversedPrevious;
                    reversedPrevious = reversedCurrent;
                    reversedCurrent = nextNode;
                }

                previous.next = reversedPrevious;
                current.next = reversedCurrent;
                previous = current;

            } else {

                for (int i = 0; i < nodeCount; i++) {
                    previous = previous.next;
                }
            }

            groupLength++;
        }

        return head;
    }
}