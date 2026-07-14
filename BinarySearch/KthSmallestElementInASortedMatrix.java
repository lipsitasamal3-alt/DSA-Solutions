/*
---------------------------------------------------------
Problem: Kth Smallest Element in a Sorted Matrix

Platform: LeetCode

Difficulty: Medium

Approach:
Binary Search on Answer

Algorithm:
1. Set the search range:
   - low = smallest element in the matrix.
   - high = largest element in the matrix.
2. While low is less than high:
   - Compute the middle value.
   - Count how many elements in the matrix are less than
     or equal to the middle value.
3. If the count is at least k:
   - Search the left half by updating high.
4. Otherwise:
   - Search the right half by updating low.
5. Return low as the kth smallest element.

Time Complexity:
O(n × log(max - min))

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
---------------------------------------------------------
*/

class Solution {

    private int countLessEqual(int[][] matrix, int target, int n) {

        int count = 0;
        int row = n - 1;
        int col = 0;

        while (row >= 0 && col < n) {

            if (matrix[row][col] <= target) {

                count += (row + 1);
                col++;

            } else {

                row--;
            }
        }

        return count;
    }

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (countLessEqual(matrix, mid, n) >= k) {

                high = mid;

            } else {

                low = mid + 1;
            }
        }

        return low;
    }
}