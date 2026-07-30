/*
---------------------------------------------------------
Problem: Binary Tree Preorder Traversal

Platform: LeetCode

Difficulty: Easy

Approach:
Iterative DFS (Stack)

Algorithm:
1. If the tree is empty, return an empty list.
2. Initialize a stack and push the root node.
3. While the stack is not empty:
   - Pop the top node.
   - Add its value to the result.
   - Push its right child (if it exists).
   - Push its left child (if it exists).
4. Since the stack is LIFO, the left child is processed before the right child.
5. Return the preorder traversal result.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/binary-tree-preorder-traversal/
---------------------------------------------------------
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) {
 *         this.val = val;
 *     }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }
}