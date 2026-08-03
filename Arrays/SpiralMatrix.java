/*
---------------------------------------------------------
Problem: Spiral Matrix

Platform: LeetCode

Difficulty: Medium

Approach:
Simulation

Algorithm:
1. Initialize four boundaries:
   - top = first row
   - bottom = last row
   - left = first column
   - right = last column
2. While the boundaries are valid:
   - Traverse the top row from left to right.
   - Move the top boundary down.
   - Traverse the right column from top to bottom.
   - Move the right boundary left.
   - If rows remain, traverse the bottom row from right to left.
   - Move the bottom boundary up.
   - If columns remain, traverse the left column from bottom to top.
   - Move the left boundary right.
3. Continue until all elements are visited.
4. Return the resulting list.

Time Complexity:
O(m × n)

Space Complexity:
O(1) (excluding the output list)

Link:
https://leetcode.com/problems/spiral-matrix/
---------------------------------------------------------
*/

class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}