/*
---------------------------------------------------------
Problem: Populating Next Right Pointers in Each Node II

Platform: LeetCode

Difficulty: Medium

Approach:
Level Traversal Using Next Pointers

Algorithm:
1. If the root is null, return null.
2. Start traversing from the current level's leftmost node.
3. For each level:
   - Create a dummy node to build the next level.
   - Maintain a tail pointer to connect child nodes.
4. Traverse the current level using existing next pointers.
5. For each node:
   - If the left child exists, connect it to tail.
   - If the right child exists, connect it to tail.
6. After finishing the current level, move to the first node
   of the next level using dummy.next.
7. Repeat until all levels are processed.
8. Return the root.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
---------------------------------------------------------
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Node current = root;

        while (current != null) {

            Node dummy = new Node(0);
            Node tail = dummy;

            while (current != null) {

                if (current.left != null) {
                    tail.next = current.left;
                    tail = tail.next;
                }

                if (current.right != null) {
                    tail.next = current.right;
                    tail = tail.next;
                }

                current = current.next;
            }

            current = dummy.next;
        }

        return root;
    }
}