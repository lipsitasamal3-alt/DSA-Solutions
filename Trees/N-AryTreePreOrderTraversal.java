/*
---------------------------------------------------------
Problem: N-ary Tree Preorder Traversal

Platform: LeetCode

Difficulty: Easy

Approach:
Iterative DFS (Stack)

Algorithm:
1. If the root is null, return an empty list.
2. Initialize a stack and push the root node.
3. While the stack is not empty:
   - Pop the top node.
   - Add its value to the result list.
   - Push its children onto the stack in reverse order.
4. Reversing the order ensures the leftmost child is processed first.
5. Return the result list.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/n-ary-tree-preorder-traversal/
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
        children = _children;
        val = _val;
    }
};
*/

class Solution {

    public List<Integer> preorder(Node root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            Node current = stack.pop();
            result.add(current.val);

            if (current.children != null) {

                for (int i = current.children.size() - 1; i >= 0; i--) {
                    stack.push(current.children.get(i));
                }
            }
        }

        return result;
    }
}