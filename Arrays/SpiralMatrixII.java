/*
---------------------------------------------------------
Problem: Spiral Matrix II

Platform: LeetCode

Difficulty: Medium

Approach:
Matrix Traversal + Simulation

Algorithm:
1. Create an `n x n` matrix.

2. Maintain four boundaries:
   - `left`   → left boundary
   - `right`  → right boundary
   - `top`    → top boundary
   - `bottom` → bottom boundary

3. Start filling the matrix with `num = 1`.

4. Traverse the current top row from left to right.
   Then move the top boundary down.

5. Traverse the current right column from top to bottom.
   Then move the right boundary left.

6. If rows are still available, traverse the current bottom
   row from right to left.
   Then move the bottom boundary up.

7. If columns are still available, traverse the current left
   column from bottom to top.
   Then move the left boundary right.

8. Continue until all boundaries cross.

9. Return the completed spiral matrix.

Time Complexity:
O(n²)

Space Complexity:
O(n²)
(The returned matrix requires O(n²) space.)

Link:
https://leetcode.com/problems/spiral-matrix-ii/
---------------------------------------------------------
*/

class Solution {

    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        int num = 1;

        // Continue while there is an unfilled layer
        while (left <= right && top <= bottom) {

            // Traverse top row: left -> right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }

            top++;

            // Traverse right column: top -> bottom
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }

            right--;

            // Traverse bottom row: right -> left
            if (top <= bottom) {

                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }

                bottom--;
            }

            // Traverse left column: bottom -> top
            if (left <= right) {

                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }

                left++;
            }
        }

        return matrix;
    }
}