/*
---------------------------------------------------------
Problem: Rotate Image

Platform: LeetCode

Difficulty: Medium

Approach:
Matrix Transposition + Row Reversal

Algorithm:
1. Find the size of the square matrix.
2. Transpose the matrix by swapping matrix[i][j]
   with matrix[j][i].
3. Reverse each row of the transposed matrix.
4. The resulting matrix is rotated by 90 degrees
   clockwise.

Time Complexity:
O(n²)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/rotate-image/
---------------------------------------------------------
*/

class Solution {

    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = n - 1;

            while (left < right) {

                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }
}