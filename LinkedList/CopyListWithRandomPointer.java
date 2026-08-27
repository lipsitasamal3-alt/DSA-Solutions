/*
---------------------------------------------------------
Problem: Copy List with Random Pointer

Platform: LeetCode

Difficulty: Medium

Approach:
Linked List + In-Place Node Interleaving

Algorithm:
1. Traverse the original linked list and create a copy of
   every node.

2. Insert each copied node immediately after its original
   node.

   Example:
   Original:  A -> B -> C
   Modified:  A -> A' -> B -> B' -> C -> C'

3. Traverse the modified list and assign the `random`
   pointer of each copied node.
   - If `curr.random` is not null, then the copied random
     node is `curr.random.next`.

4. Separate the original list and the copied list:
   - Restore the original `next` pointers.
   - Connect all copied nodes together.

5. Return the head of the copied list.

Time Complexity:
O(n)

Space Complexity:
O(1)
(Excluding the space required for the copied nodes.)

Link:
https://leetcode.com/problems/copy-list-with-random-pointer/
---------------------------------------------------------
*/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    public Node copyRandomList(Node head) {

        // Handle empty list
        if (head == null) {
            return null;
        }

        /*
         * Step 1:
         * Create a copy of every node and insert it
         * immediately after the original node.
         */
        Node curr = head;

        while (curr != null) {

            Node nextNode = curr.next;

            Node copyNode = new Node(curr.val);

            curr.next = copyNode;
            copyNode.next = nextNode;

            curr = nextNode;
        }

        /*
         * Step 2:
         * Assign random pointers to copied nodes.
         */
        curr = head;

        while (curr != null) {

            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        /*
         * Step 3:
         * Separate the copied list from the original list.
         */
        curr = head;

        Node dummyHead = new Node(0);
        Node copyCurr = dummyHead;

        while (curr != null) {

            Node nextNode = curr.next.next;

            // Add copied node to the new list
            copyCurr.next = curr.next;
            copyCurr = copyCurr.next;

            // Restore original list
            curr.next = nextNode;

            curr = nextNode;
        }

        return dummyHead.next;
    }
}