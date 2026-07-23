/*
---------------------------------------------------------
Problem: Flatten Binary Tree to Linked List

Platform: LeetCode

Difficulty: Medium

Approach:
Iterative Morris-style Traversal

Algorithm:
1. Start from the root node.
2. While the current node is not null:
   - If the current node has a left child:
     - Find the rightmost node of the left subtree.
     - Connect the current node's right subtree to this rightmost node.
     - Move the left subtree to the right.
     - Set the left child to null.
   - Move to the right child.
3. Continue until all nodes are processed.
4. The tree is flattened into a right-skewed linked list following preorder traversal.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
---------------------------------------------------------
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public void flatten(TreeNode root) {

        TreeNode current = root;

        while (current != null) {

            if (current.left != null) {

                TreeNode next = current.left;

                while (next.right != null) {
                    next = next.right;
                }

                next.right = current.right;
                current.right = current.left;
                current.left = null;
            }

            current = current.right;
        }
    }
}