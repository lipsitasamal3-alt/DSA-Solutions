/*
---------------------------------------------------------
Problem: Diagonal Traverse

Platform: LeetCode

Difficulty: Medium

Approach:
Arrays + Matrix Traversal

Algorithm:
1. Start at the top-left corner.
2. Maintain a direction:
      1  → move up-right
     -1  → move down-left
3. While moving in a direction:
   - Move diagonally until reaching a boundary.
4. When a boundary is reached:
   - Change direction.
   - Move to the next valid starting cell.
5. Continue until all m × n elements are visited.

Time Complexity:
O(m × n)

Space Complexity:
O(1) extra space
(excluding the output array)

Link:
https://leetcode.com/problems/diagonal-traverse/
---------------------------------------------------------
*/

class Solution {

    public int[] findDiagonalOrder(int[][] mat) {

        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0];
        }

        int m = mat.length;
        int n = mat[0].length;

        int[] result = new int[m * n];

        int row = 0;
        int col = 0;

        // 1 = up-right, -1 = down-left
        int direction = 1;

        for (int i = 0; i < m * n; i++) {

            result[i] = mat[row][col];

            if (direction == 1) {

                if (col == n - 1) {
                    row++;
                    direction = -1;

                } else if (row == 0) {
                    col++;
                    direction = -1;

                } else {
                    row--;
                    col++;
                }

            } else {

                if (row == m - 1) {
                    col++;
                    direction = 1;

                } else if (col == 0) {
                    row++;
                    direction = 1;

                } else {
                    row++;
                    col--;
                }
            }
        }

        return result;
    }
}