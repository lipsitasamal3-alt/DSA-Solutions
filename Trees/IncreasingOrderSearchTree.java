/*
---------------------------------------------------------
Problem: Increasing Order Search Tree

Platform: LeetCode

Difficulty: Easy

Approach:
Inorder Traversal (DFS)

Algorithm:
1. Create a dummy node and maintain a pointer `curr` to build the new tree.
2. Perform an inorder traversal of the BST.
3. For each visited node:
   - Recursively process the left subtree.
   - Remove its left child by setting it to null.
   - Attach the node to the right of `curr`.
   - Move `curr` to the current node.
   - Recursively process the right subtree.
4. Since inorder traversal visits nodes in sorted order,
   the resulting tree contains only right children.
5. Return `dummy.right` as the root of the new tree.

Time Complexity:
O(n)

Space Complexity:
O(h)
(h = height of the tree due to recursion stack)

Link:
https://leetcode.com/problems/increasing-order-search-tree/
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

    private TreeNode current;

    public TreeNode increasingBST(TreeNode root) {

        TreeNode dummy = new TreeNode(0);
        current = dummy;

        inorder(root);

        return dummy.right;
    }

    private void inorder(TreeNode node) {

        if (node == null) {
            return;
        }

        inorder(node.left);

        node.left = null;
        current.right = node;
        current = node;

        inorder(node.right);
    }
}