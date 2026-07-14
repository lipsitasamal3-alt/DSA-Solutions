/*
---------------------------------------------------------
Problem: Search a 2D Matrix II

Platform: LeetCode

Difficulty: Medium

Approach:
Staircase Search

Algorithm:
1. Handle the edge case where the matrix is empty.
2. Start from the top-right corner of the matrix.
3. While the current position is within bounds:
   - If the current element equals the target,
     return true.
   - If the current element is greater than the target,
     move one column to the left.
   - Otherwise, move one row downward.
4. If the target is not found, return false.

Time Complexity:
O(m + n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/search-a-2d-matrix-ii/
---------------------------------------------------------
*/

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {

            if (matrix[row][col] == target) {

                return true;

            } else if (matrix[row][col] > target) {

                col--;

            } else {

                row++;
            }
        }

        return false;
    }
}