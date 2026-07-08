/*
---------------------------------------------------------
Problem: Search a 2D Matrix

Platform: LeetCode

Difficulty: Medium

Approach:
Binary Search

Algorithm:
1. Treat the 2D matrix as a flattened sorted array.
2. Perform binary search on the virtual array.
3. Convert the middle index back to row and column:
   - row = mid / number_of_columns
   - col = mid % number_of_columns
4. Compare the current element with the target.
5. Return true if found; otherwise continue searching.
6. Return false if the target does not exist.

Time Complexity: O(log(m × n))

Space Complexity: O(1)

Link:
https://leetcode.com/problems/search-a-2d-matrix/
---------------------------------------------------------
*/

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int midValue = matrix[mid / n][mid % n];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}