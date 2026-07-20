/*
---------------------------------------------------------
Problem: N-ary Tree Postorder Traversal

Platform: LeetCode

Difficulty: Easy

Approach:
Iterative DFS (Stack)

Algorithm:
1. If the root is null, return an empty list.
2. Initialize a stack and push the root node.
3. While the stack is not empty:
   - Pop the top node.
   - Insert its value at the beginning of the result list.
   - Push all of its children onto the stack from left to right.
4. Adding values to the front of the result produces the correct postorder traversal.
5. Return the result list.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/n-ary-tree-postorder-traversal/
---------------------------------------------------------
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {

    public List<Integer> postorder(Node root) {

        LinkedList<Integer> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            Node current = stack.pop();
            result.addFirst(current.val);

            for (Node child : current.children) {
                if (child != null) {
                    stack.push(child);
                }
            }
        }

        return result;
    }
}