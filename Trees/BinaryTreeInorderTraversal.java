/*
---------------------------------------------------------
Problem: Binary Tree Inorder Traversal

Platform: LeetCode

Difficulty: Easy

Approach:
Recursive Depth-First Search (DFS)

Algorithm:
1. Traverse the left subtree recursively.
2. Visit the current node and add its value to the result.
3. Traverse the right subtree recursively.
4. Return the inorder traversal list.

Time Complexity: O(n)

Space Complexity: O(n)
(Recursion stack in the worst case)

Link:
https://leetcode.com/problems/binary-tree-inorder-traversal/
---------------------------------------------------------
*/

import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode node, List<Integer> list) {

        if (node == null) {
            return;
        }

        traverse(node.left, list);
        list.add(node.val);
        traverse(node.right, list);
    }
}