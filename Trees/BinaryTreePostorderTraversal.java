/*
---------------------------------------------------------
Problem: Binary Tree Postorder Traversal

Platform: LeetCode

Difficulty: Easy

Approach:
Iterative DFS (Stack)

Algorithm:
1. If the tree is empty, return an empty list.
2. Initialize a stack and push the root node.
3. While the stack is not empty:
   - Pop the top node.
   - Insert its value at the beginning of the result list.
   - Push its left child (if it exists).
   - Push its right child (if it exists).
4. Since values are inserted at the front, the traversal order
   becomes Left → Right → Root.
5. Return the postorder traversal result.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/binary-tree-postorder-traversal/
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

    public List<Integer> postorderTraversal(TreeNode root) {

        LinkedList<Integer> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode current = stack.pop();
            result.addFirst(current.val);

            if (current.left != null) {
                stack.push(current.left);
            }

            if (current.right != null) {
                stack.push(current.right);
            }
        }

        return result;
    }
}