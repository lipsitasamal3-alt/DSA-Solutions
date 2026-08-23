/*
---------------------------------------------------------
Problem: Set Matrix Zeroes

Platform: LeetCode

Difficulty: Medium

Approach:
Matrix Traversal + In-Place Marking

Algorithm:
1. Use the first row and first column as markers to store
   which rows and columns need to be set to zero.

2. Use `colo` to separately track whether the first column
   itself needs to be zeroed.

3. Traverse the entire matrix:
   - If `matrix[i][j] == 0`, mark its row by setting
     `matrix[i][0] = 0`.
   - Mark its column by setting `matrix[0][j] = 0`.
   - If the zero is already in the first column, set
     `colo = 0`.

4. Traverse the matrix excluding the first row and first
   column.
   - If either its row marker or column marker is zero,
     set the current element to zero.

5. If `matrix[0][0] == 0`, set the entire first row to zero.

6. If `colo == 0`, set the entire first column to zero.

7. The matrix is modified in-place without using an
   additional matrix.

Time Complexity:
O(n × m)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/set-matrix-zeroes/
---------------------------------------------------------
*/

class Solution {

    public void setZeroes(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        // Tracks whether the first column needs to be zeroed
        int colo = 1;

        // Use first row and first column as markers
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == 0) {

                    // Mark the current row
                    matrix[i][0] = 0;

                    if (j != 0) {

                        // Mark the current column
                        matrix[0][j] = 0;

                    } else {

                        // First column itself contains zero
                        colo = 0;
                    }
                }
            }
        }

        // Set inner matrix elements to zero based on markers
        for (int i = 1; i < n; i++) {

            for (int j = 1; j < m; j++) {

                if (matrix[i][j] != 0) {

                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // Set the first row to zero if required
        if (matrix[0][0] == 0) {

            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        // Set the first column to zero if required
        if (colo == 0) {

            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}