/*
---------------------------------------------------------
Problem: Verify Preorder Serialization of a Binary Tree

Platform: LeetCode

Difficulty: Medium

Approach:
Greedy (Slot Counting)

Algorithm:
1. Start with one available slot for the root.
2. Traverse the preorder serialization token by token.
3. For every node:
   - Consume one slot.
   - If no slot is available, return false.
4. If the node is not null ('#'):
   - It creates two new child slots.
5. Continue until all tokens are processed.
6. The serialization is valid only if all slots are exactly used.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
---------------------------------------------------------
*/

class Solution {

    public boolean isValidSerialization(String preorder) {

        int slots = 1;
        int n = preorder.length();

        for (int i = 0; i < n; i++) {

            if (preorder.charAt(i) == ',') {
                continue;
            }

            boolean isNull = (preorder.charAt(i) == '#');

            while (i < n && preorder.charAt(i) != ',') {
                i++;
            }

            slots--;

            if (slots < 0) {
                return false;
            }

            if (!isNull) {
                slots += 2;
            }
        }

        return slots == 0;
    }
}