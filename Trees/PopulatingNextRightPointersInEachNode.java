/*
---------------------------------------------------------
Problem: Populating Next Right Pointers in Each Node

Platform: LeetCode

Difficulty: Medium

Approach:
Recursive DFS

Algorithm:
1. If the root is null, return null.
2. If the current node has a left child:
   - Connect the left child to the right child.
   - If the current node has a next pointer:
     - Connect the right child to the left child of the next node.
3. Recursively process the left subtree.
4. Recursively process the right subtree.
5. Return the root after all next pointers are populated.

Time Complexity:
O(n)

Space Complexity:
O(h)
(h = height of the tree due to recursion stack)

Link:
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
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

        if (root.left != null) {

            root.left.next = root.right;

            if (root.next != null) {
                root.right.next = root.next.left;
            }

            connect(root.left);
            connect(root.right);
        }

        return root;
    }
}