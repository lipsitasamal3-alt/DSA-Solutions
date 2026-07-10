/*
---------------------------------------------------------
Problem: Minimum Path Sum

Platform: LeetCode

Difficulty: Medium

Approach:
Dynamic Programming (In-Place)

Algorithm:
1. Let m and n be the number of rows and columns.
2. Update the first column by accumulating values from top to bottom.
3. Update the first row by accumulating values from left to right.
4. For each remaining cell:
   - Add the minimum of the top and left neighboring cells.
5. The bottom-right cell contains the minimum path sum.
6. Return the value at the bottom-right cell.

Time Complexity:
O(m × n)

Space Complexity:
O(1) (excluding the input grid)

Link:
https://leetcode.com/problems/minimum-path-sum/
---------------------------------------------------------
*/

class Solution {

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {

                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[m - 1][n - 1];
    }
}